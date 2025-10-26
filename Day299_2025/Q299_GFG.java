import java.util.*;

class Q299_GFG {
    public static int minCost(int[] arr) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : arr) pq.offer((long) num);

        long totalCost = 0;

        while (pq.size() > 1) {
            long first = pq.poll();
            long second = pq.poll();
            long cost = first + second;
            totalCost += cost;
            pq.offer(cost);
        }

        return (int) totalCost;
    }
}
