class Q129_Leetcode {
    static final long MOD = (long) 1e9 + 7;

    public int countBalancedPermutations(String num) {
        int n = num.length(), total = 0;
        int[] cnt = new int[10];
        for (char ch : num.toCharArray()) {
            int d = ch - '0';
            cnt[d]++;
            total += d;
        }

        if (total % 2 != 0) return 0;
        int target = total / 2;
        int maxOdd = (n + 1) / 2;

        long[][] comb = new long[maxOdd + 1][maxOdd + 1];
        for (int i = 0; i <= maxOdd; i++) {
            comb[i][0] = comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        long[][] f = new long[target + 1][maxOdd + 1];
        f[0][0] = 1;

        int psum = 0, totSum = 0;

        for (int d = 0; d <= 9; d++) {
            int c = cnt[d];
            if (c == 0) continue;
            psum += c;
            totSum += d * c;

            for (int odd = Math.min(psum, maxOdd); odd >= Math.max(0, psum - (n - maxOdd)); odd--) {
                int even = psum - odd;

                for (int s = Math.min(totSum, target); s >= Math.max(0, totSum - target); s--) {
                    long res = 0;
                    for (int j = Math.max(0, c - even); j <= Math.min(c, odd) && d * j <= s; j++) {
                        long ways = comb[odd][j] * comb[even][c - j] % MOD;
                        res = (res + ways * f[s - d * j][odd - j] % MOD) % MOD;
                    }
                    f[s][odd] = res;
                }
            }
        }

        return (int) f[target][maxOdd];
    }
}
