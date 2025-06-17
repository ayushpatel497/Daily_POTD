import java.util.*;

class Q168_GFG {
    public int minimumCoins(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] pre = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + arr[i - 1];
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int high = arr[i] + k;
            int ub = upperBound(arr, high);  // index of first element > high
            int cost = pre[i] + (pre[n] - pre[ub]) - (n - ub) * high;
            ans = Math.min(ans, cost);
        }

        return ans;
    }

    // Custom upper_bound implementation
    private int upperBound(int[] arr, int key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
