import java.util.HashMap;
import java.util.Map;

class Q058_Leetcode {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        int[][] dp = new int[n][n];
        int maxLen = 0;

        // Store the indices of each number in the array
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        // Iterate over all pairs (i, j) where i < j
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int prev = arr[j] - arr[i]; // Find the expected previous number
                if (prev < arr[i] && indexMap.containsKey(prev)) {
                    int k = indexMap.get(prev);
                    dp[i][j] = dp[k][i] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen == 0 ? 0 : maxLen + 2;
    }
}
