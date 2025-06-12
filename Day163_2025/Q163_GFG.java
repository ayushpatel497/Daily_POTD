import java.util.ArrayList;
import java.util.List;

class Q163_GFG {
    public int[] printKClosest(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0, high = n - 1, pos = -1;

        // Binary search to find the position of the closest element less than x
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < x) {
                pos = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int left = pos, right = pos + 1;
        if (right < n && arr[right] == x) right++;

        List<Integer> result = new ArrayList<>();
        while (left >= 0 && right < n && result.size() < k) {
            int leftDiff = Math.abs(arr[left] - x);
            int rightDiff = Math.abs(arr[right] - x);

            if (leftDiff < rightDiff) {
                result.add(arr[left--]);
            } else {
                result.add(arr[right++]);
            }
        }

        while (left >= 0 && result.size() < k) {
            result.add(arr[left--]);
        }

        while (right < n && result.size() < k) {
            result.add(arr[right++]);
        }

        // Convert list to array
        return result.stream().mapToInt(i -> i).toArray();
    }
}
