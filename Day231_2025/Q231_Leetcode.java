class Q231_Leetcode {
    public long zeroFilledSubarray(int[] nums) {
        long cnt = 0, streak = 0;
        for (int num : nums) {
            if (num == 0) {
                streak++;
                cnt += streak;
            } else {
                streak = 0;
            }
        }
        return cnt;
    }
}
