import java.util.PriorityQueue;

class Q044_Leetcode {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Insert all elements into the min-heap
        for (int num : nums) {
            minHeap.add(num);
        }
        
        int count = 0;
        
        while (minHeap.peek() < k) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            count++;
            
            int doubledMin = Math.min(first, second) * 2;
            int val = (doubledMin >= k) ? doubledMin : doubledMin + Math.max(first, second);
            
            minHeap.add(val);
        }
        
        return count;
    }
}
