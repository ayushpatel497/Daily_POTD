import java.util.*;

class Q295_GFG {
    public void nearlySorted(int[] arr, int k) {
        // Q. Nearly Sorted
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Insert first k elements
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        int index = 0;

        // Process remaining elements
        for (int i = k; i < arr.length; i++) {
            pq.add(arr[i]);
            arr[index++] = pq.poll();
        }

        // Empty the remaining elements in the heap
        while (!pq.isEmpty()) {
            arr[index++] = pq.poll();
        }
    }
}
