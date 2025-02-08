import java.util.*;

class Q039_Leetcode {
    private Map<Integer, Integer> indexToNumbers;
    private Map<Integer, PriorityQueue<Integer>> numberToIndices;

    public Q039_Leetcode() {
        indexToNumbers = new HashMap<>();
        numberToIndices = new HashMap<>();
    }
    
    public void change(int index, int number) {
        // Update the mapping of index to number
        indexToNumbers.put(index, number);
        
        // Ensure the number has a min-heap (priority queue)
        numberToIndices.putIfAbsent(number, new PriorityQueue<>());
        
        // Add the index to the heap of the corresponding number
        numberToIndices.get(number).add(index);
    }
    
    public int find(int number) {
        if (!numberToIndices.containsKey(number)) {
            return -1;
        }
        
        PriorityQueue<Integer> minHeap = numberToIndices.get(number);
        
        // Ensure the top index is still mapped to this number
        while (!minHeap.isEmpty()) {
            int index = minHeap.peek();
            if (indexToNumbers.get(index) == number) {
                return index;
            }
            minHeap.poll(); // Remove outdated indices
        }
        
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index, number);
 * int param_2 = obj.find(number);
 */
