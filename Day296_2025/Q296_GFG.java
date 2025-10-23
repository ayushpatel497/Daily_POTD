import java.util.*;

class Q296_GFG {
    private int squaredDist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> squaredDist(b) - squaredDist(a)  // max heap by distance
        );

        for (int[] point : points) {
            if (maxHeap.size() < k) {
                maxHeap.add(point);
            } else if (squaredDist(point) < squaredDist(maxHeap.peek())) {
                maxHeap.poll();
                maxHeap.add(point);
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            int[] p = maxHeap.poll();
            result.add(new ArrayList<>(Arrays.asList(p[0], p[1])));
        }
        return result;
    }
}
