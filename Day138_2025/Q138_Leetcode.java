import java.util.*;

class Q138_Leetcode {
    int mod = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        Map<Integer, int[]> valid = new HashMap<>();
        int mask_end = (int)Math.pow(3, m);

        // Generate all valid column states
        for (int mask = 0; mask < mask_end; mask++) {
            int[] color = new int[m];
            int temp = mask;
            boolean isValid = true;
            for (int i = 0; i < m; i++) {
                color[i] = temp % 3;
                temp /= 3;
                if (i > 0 && color[i] == color[i - 1]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) valid.put(mask, color);
        }

        // Build adjacency map
        Map<Integer, List<Integer>> adjacent = new HashMap<>();
        for (var e1 : valid.entrySet()) {
            int mask1 = e1.getKey();
            int[] c1 = e1.getValue();
            for (var e2 : valid.entrySet()) {
                int mask2 = e2.getKey();
                int[] c2 = e2.getValue();
                boolean compatible = true;
                for (int i = 0; i < m; i++) {
                    if (c1[i] == c2[i]) {
                        compatible = false;
                        break;
                    }
                }
                if (compatible) {
                    adjacent.computeIfAbsent(mask1, _ -> new ArrayList<>()).add(mask2);
                }
            }
        }

        // DP initialization
        int[] dp = new int[mask_end];
        for (int mask : valid.keySet()) dp[mask] = 1;

        // DP iteration for each column
        for (int col = 1; col < n; col++) {
            int[] newDp = new int[mask_end];
            for (int mask2 : valid.keySet()) {
                for (int mask1 : adjacent.getOrDefault(mask2, new ArrayList<>())) {
                    newDp[mask2] = (newDp[mask2] + dp[mask1]) % mod;
                }
            }
            dp = newDp;
        }

        // Sum up all ways
        int ans = 0;
        for (int val : dp) {
            ans = (ans + val) % mod;
        }
        return ans;
    }
}
