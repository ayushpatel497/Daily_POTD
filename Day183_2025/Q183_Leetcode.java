import java.util.*;

class Q183_Leetcode {
    static final int MOD = 1000000007;

    public int possibleStringCount(String word, int k) {
        int n = word.length();
        List<Integer> freq = new ArrayList<>();
        int cnt = 1;

        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                cnt++;
            } else {
                freq.add(cnt);
                cnt = 1;
            }
        }
        freq.add(cnt);

        long ans = 1;
        for (int o : freq) {
            ans = (ans * o) % MOD;
        }

        if (freq.size() >= k) {
            return (int) ans;
        }

        int[] f = new int[k];
        int[] g = new int[k];
        f[0] = 1;
        Arrays.fill(g, 1);

        for (int i = 0; i < freq.size(); i++) {
            int[] f_new = new int[k];
            for (int j = 1; j < k; j++) {
                f_new[j] = g[j - 1];
                if (j - freq.get(i) - 1 >= 0) {
                    f_new[j] = (f_new[j] - g[j - freq.get(i) - 1] + MOD) % MOD;
                }
            }
            g[0] = f_new[0];
            for (int j = 1; j < k; j++) {
                g[j] = (g[j - 1] + f_new[j]) % MOD;
            }
            f = f_new;
        }

        return (int) ((ans - g[k - 1] + MOD) % MOD);
    }
}
