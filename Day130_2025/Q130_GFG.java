import java.util.*;

class Q130_GFG {
    static int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int[] temp = new int[n];
        
        for (int i = 0; i < n; i++) {
            temp[i] = (arr[i] > k) ? 1 : -1;
        }

        Map<Integer, Integer> index = new HashMap<>();
        int csum = 0, ans = 0;

        for (int i = 0; i < n; i++) {
            csum += temp[i];
            if (csum > 0) {
                ans = i + 1;
            } else if (index.containsKey(csum - 1)) {
                ans = Math.max(ans, i - index.get(csum - 1));
            }

            index.putIfAbsent(csum, i);
        }

        return ans;
    }
}
