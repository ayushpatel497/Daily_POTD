class Q177_Leetcode {
    public int longestSubsequence(String s, int k) {
        int sm = 0;
        int cnt = 0;
        int bits = 32 - Integer.numberOfLeadingZeros(k);

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(n - 1 - i);
            if (ch == '1') {
                if (i < bits && sm + (1 << i) <= k) {
                    sm += 1 << i;
                    cnt++;
                }
            } else {
                cnt++;
            }
        }
        return cnt;
    }
}
