class Q334_GFG {
    public static int countSubs(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        char[] str = s.toCharArray();

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 1; j--) {
                int cnt = 0;
                int t = i;

                while (j >= 1 && str[t - 1] == str[j - 1]) {
                    cnt++;
                    t--;
                    j--;
                }
                if (cnt > 0) j++;

                dp[i] = Math.max(dp[i], cnt);
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += i - dp[i];
        }
        return ans;
    }
}
