import java.util.*;

class Q244_GFG {
    public int sumOfModes(int[] arr, int k) {
        int n = arr.length;
        if (n < k) return 0;

        Map<Integer, Integer> freq = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> bucket = new TreeMap<>();
        int[] maxFreq = new int[1]; // mutable container
        maxFreq[0] = 0;

        // Update maxFreq from the bucket
        Runnable updateMaxFreq = () -> {
            if (!bucket.isEmpty()) maxFreq[0] = bucket.lastKey();
            else maxFreq[0] = 0;
        };

        // Add element to the window
        java.util.function.Consumer<Integer> add = x -> {
            int f = freq.getOrDefault(x, 0);
            if (f > 0) {
                bucket.get(f).remove(x);
                if (bucket.get(f).isEmpty()) bucket.remove(f);
            }
            freq.put(x, f + 1);
            bucket.computeIfAbsent(f + 1, _ -> new TreeSet<>()).add(x);
            maxFreq[0] = Math.max(maxFreq[0], f + 1);
        };

        // Remove element from the window
        java.util.function.Consumer<Integer> remove = x -> {
            int f = freq.get(x);
            bucket.get(f).remove(x);
            if (bucket.get(f).isEmpty()) bucket.remove(f);
            freq.put(x, f - 1);
            if (f - 1 > 0) bucket.computeIfAbsent(f - 1, _ -> new TreeSet<>()).add(x);
            if (!bucket.containsKey(maxFreq[0])) updateMaxFreq.run();
        };

        // Get current mode
        java.util.function.Supplier<Integer> getMode = () -> bucket.get(maxFreq[0]).first();

        // Initialize the first window
        for (int i = 0; i < k; i++) add.accept(arr[i]);
        int ans = getMode.get();

        // Slide the window
        for (int i = 0, j = k; j < n; i++, j++) {
            remove.accept(arr[i]);
            add.accept(arr[j]);
            ans += getMode.get();
        }

        return ans;
    }

    public static void main(String[] args) {
        Q244_GFG sol = new Q244_GFG();
        int[] arr = {1, 2, 2, 1, 3};
        int k = 3;
        System.out.println(sol.sumOfModes(arr, k)); // Example output
    }
}
