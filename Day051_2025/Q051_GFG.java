import java.util.*;

class Q051_GFG {
    public ArrayList<Double> getMedian(int[] arr) {
        PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();
        ArrayList<Double> ans = new ArrayList<>();
        
        for (int num : arr) {
            leftMaxHeap.add(num);
            
            // Balance: move the largest from left to right.
            rightMinHeap.add(leftMaxHeap.poll());
            
            // If right has more elements, move one back to left.
            if (rightMinHeap.size() > leftMaxHeap.size()) {
                leftMaxHeap.add(rightMinHeap.poll());
            }
            
            double median;
            if (leftMaxHeap.size() > rightMinHeap.size()) {
                median = leftMaxHeap.peek();
            } else {
                median = (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
            }
            ans.add(median);
        }
        return ans;
    }
}
