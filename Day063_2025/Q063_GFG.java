import java.util.*;

class Q063_GFG {
    public static int lis(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] > ans.get(ans.size() - 1)) {
                ans.add(arr[i]);
            } else {
                int low = Collections.binarySearch(ans, arr[i]);
                if (low < 0) low = -(low + 1);
                ans.set(low, arr[i]);
            }
        }
        return ans.size();
    }
}
