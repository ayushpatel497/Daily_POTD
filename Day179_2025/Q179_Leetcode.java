import java.util.*;

class Q179_Leetcode {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = i;       // store index
            pairs[i][1] = nums[i]; // store value
        }

        // Sort by value in descending order
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        // Keep the top k elements
        Arrays.sort(pairs, 0, k, Comparator.comparingInt(a -> a[0]));

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pairs[i][1];
        }

        return res;
    }
}
