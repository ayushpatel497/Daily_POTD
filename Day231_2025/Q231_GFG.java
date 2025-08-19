import java.util.*;

class Q231_GFG {
    public ArrayList<Integer> farMin(int[] arr) {
        int n = arr.length;
        int[] suffix = new int[n + 1];
        Arrays.fill(suffix, Integer.MAX_VALUE);

        // build suffix min
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = Math.min(suffix[i + 1], arr[i]);
        }

        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));

        // binary search for each element
        for (int i = 0; i < n - 1; i++) {
            int s = i + 1, e = n - 1;
            while (s <= e) {
                int mid = s + (e - s) / 2;
                if (suffix[mid] < arr[i]) {
                    result.set(i, mid);
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return result;
    }
}
