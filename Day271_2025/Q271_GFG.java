import java.util.*;

class Q271_GFG {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        PriorityQueue<Integer> maxi = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> mini = new PriorityQueue<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        int l = 0, in = -1, start = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            maxi.add(arr[i]);
            mini.add(arr[i]);

            while (!maxi.isEmpty() && !mini.isEmpty() && maxi.peek() - mini.peek() > x) {
                freq.put(arr[start], freq.get(arr[start]) - 1);
                while (!maxi.isEmpty() && freq.getOrDefault(maxi.peek(), 0) == 0) {
                    maxi.poll();
                }
                while (!mini.isEmpty() && freq.getOrDefault(mini.peek(), 0) == 0) {
                    mini.poll();
                }
                start++;
            }

            if (l < i - start + 1) {
                in = start;
                l = i - start + 1;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = in; i < in + l; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }
}
