import java.util.*;

class Q297_GFG {
    public boolean isPossible(int[] arr, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> skip = new HashMap<>();

        for (int num : arr)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        for (int i = 0; i < arr.length; i++) {
            if (skip.getOrDefault(arr[i], 0) > 0 || freq.getOrDefault(arr[i] - 1, 0) > 0)
                continue;

            int start = arr[i];
            while (freq.getOrDefault(start, 0) > 0) {
                freq.put(start, freq.get(start) - 1);
                if (start != arr[i])
                    skip.put(start, skip.getOrDefault(start, 0) + 1);
                start++;
            }
            if ((start - arr[i]) < k)
                return false;
        }
        return true;
    }
}
