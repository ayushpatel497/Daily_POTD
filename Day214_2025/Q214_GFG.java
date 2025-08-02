import java.util.*;

class Q214_GFG {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > k)
                sum++;
            else
                sum--;

            if (!map.containsKey(sum))
                map.put(sum, i);

            if (map.containsKey(sum - 1))
                res = Math.max(res, i - map.get(sum - 1));

            if (sum > 0)
                res = Math.max(res, i + 1);
        }
        return res;
    }
}
