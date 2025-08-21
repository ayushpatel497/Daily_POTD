import java.util.*;

class Q233_GFG {
    private boolean isPossible(int[] arr, int gap, int k) {
        int count = 1;
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - prev >= gap) {
                count++;
                prev = arr[i];
            }
            if (count == k) return true;
        }
        return false;
    }

    public int maxMinDiff(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int low = 0;
        int high = arr[n - 1] - arr[0];
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(arr, mid, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
