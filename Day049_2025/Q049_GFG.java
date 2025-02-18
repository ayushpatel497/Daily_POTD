import java.util.*;

class Q049_GFG {
    public int[][] kClosest(int[][] points, int k) {
        // Max-heap to store k closest points
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> 
            Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1])));

        for (int[] point : points) {
            int dist = point[0] * point[0] + point[1] * point[1];
            if (maxHeap.size() < k) {
                maxHeap.add(point);
            } else if (dist < (maxHeap.peek()[0] * maxHeap.peek()[0] + maxHeap.peek()[1] * maxHeap.peek()[1])) {
                maxHeap.poll();
                maxHeap.add(point);
            }
        }

        // Convert heap into a result array
        int[][] result = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            result[i++] = maxHeap.poll();
        }
        return result;
    }
}
