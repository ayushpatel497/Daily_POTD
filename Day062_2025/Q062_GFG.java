import java.util.*;

class Q062_GFG {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        int n = arr.length, start = 0, end = 0;
        int resStart = 0, resEnd = 0;
        
        Deque<Integer> minQueue = new LinkedList<>();
        Deque<Integer> maxQueue = new LinkedList<>();
        
        while (end < n) {
            while (!minQueue.isEmpty() && arr[minQueue.peekLast()] > arr[end])
                minQueue.pollLast();
            while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] < arr[end])
                maxQueue.pollLast();

            minQueue.offerLast(end);
            maxQueue.offerLast(end);

            while (arr[maxQueue.peekFirst()] - arr[minQueue.peekFirst()] > x) {
                if (minQueue.peekFirst() == start)
                    minQueue.pollFirst();
                if (maxQueue.peekFirst() == start)
                    maxQueue.pollFirst();
                start++;
            }

            if (end - start > resEnd - resStart) {
                resStart = start;
                resEnd = end;
            }

            end++;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = resStart; i <= resEnd; i++)
            result.add(arr[i]);

        return result;
    }
}
