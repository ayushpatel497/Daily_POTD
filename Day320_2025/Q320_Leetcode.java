class Q320_Leetcode {
    static final int P = 1000000007;

    public int numSub(String s) {
        int n = s.length();
        long ans = 0;
        int p = 0;

        while (p < n) {
            if (s.charAt(p) == '0') {
                p++;
                continue;
            }

            int cnt = 0;
            while (p < n && s.charAt(p) == '1') {
                cnt++;
                p++;
            }

            ans = ans + (long)(cnt + 1) * cnt / 2;
            ans %= P;
        }

        return (int) ans;
    }
}
