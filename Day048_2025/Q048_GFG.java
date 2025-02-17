import java.util.*;

class Q048_GFG {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min-heap
        
        // Add first k elements to the heap
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        // Process the remaining elements
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
        }

        // Extract k largest elements and store them in a list
        ArrayList<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        // Reverse the list to get elements in descending order
        Collections.reverse(result);
        return result;
    }
}
