import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Q173_GFG {
    public ArrayList<Integer> largestSubset(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr); // ascending order
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxLen = 0, maxIdx = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (maxIdx != -1) {
            result.add(arr[maxIdx]);
            maxIdx = parent[maxIdx];
        }

        // optional: reverse the list to maintain increasing order
        Collections.reverse(result);
        return result;
    }
}
