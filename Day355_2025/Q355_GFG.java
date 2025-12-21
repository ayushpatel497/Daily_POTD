import java.util.*;

class Q355_GFG {
    public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();

        // Store indices of each value
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        for (int[] q : queries) {
            int l = q[0], r = q[1], x = q[2];

            if (!map.containsKey(x)) {
                ans.add(0);
                continue;
            }

            ArrayList<Integer> indices = map.get(x);
            int left = lowerBound(indices, l);
            int right = upperBound(indices, r);

            ans.add(right - left);
        }

        return ans;
    }

    private int lowerBound(ArrayList<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    private int upperBound(ArrayList<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) <= target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
