import java.util.*;

class Q142_Leetcode {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int[] deltaArray = new int[nums.length + 1];
        int operations = 0;
        int j = 0;

        for (int i = 0; i < nums.length; ++i) {
            operations += deltaArray[i];
            while (j < queries.length && queries[j][0] == i) {
                heap.offer(queries[j][1]);
                j++;
            }
            while (operations < nums[i] && !heap.isEmpty() && heap.peek() >= i) {
                int right = heap.poll();
                operations += 1;
                if (right + 1 < deltaArray.length)
                    deltaArray[right + 1] -= 1;
            }
            if (operations < nums[i]) {
                return -1;
            }
        }

        return heap.size();
    }
}
