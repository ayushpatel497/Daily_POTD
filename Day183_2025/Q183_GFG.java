import java.util.*;

class Q183_GFG {
    public int totalElements(int[] arr) {
        int n = arr.length;
        if (n <= 2) return n;

        Map<Integer, Integer> map = new HashMap<>();
        int windowStart = 0;
        int res = 0;

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            while (map.size() > 2) {
                int count = map.get(arr[windowStart]) - 1;
                if (count == 0) {
                    map.remove(arr[windowStart]);
                } else {
                    map.put(arr[windowStart], count);
                }
                windowStart++;
            }

            res = Math.max(res, i - windowStart + 1);
        }

        return res;
    }
}
