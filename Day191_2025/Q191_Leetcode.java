class Q191_Leetcode {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int res = 0;
        int t1 = 0, t2 = 0;

        for (int i = 0; i < n; i++) {
            int left1 = (i == 0) ? 0 : endTime[i - 1];
            int right1 = (i == n - 1) ? eventTime : startTime[i + 1];

            if (endTime[i] - startTime[i] <= t1) {
                res = Math.max(res, right1 - left1);
            }
            t1 = Math.max(t1, startTime[i] - ((i == 0) ? 0 : endTime[i - 1]));

            res = Math.max(res, right1 - left1 - (endTime[i] - startTime[i]));

            int idx = n - i - 1;
            int left2 = (idx == 0) ? 0 : endTime[idx - 1];
            int right2 = (i == 0) ? eventTime : startTime[idx + 1];

            if (endTime[idx] - startTime[idx] <= t2) {
                res = Math.max(res, right2 - left2);
            }

            t2 = Math.max(t2, ((i == 0) ? eventTime : startTime[idx + 1]) - endTime[idx]);
        }

        return res;
    }
}
