import java.util.*;

class Q298_GFG {
    public int minOperations(int[] arr) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double arrSum = 0;

        for (int num : arr) {
            pq.offer((double) num);
            arrSum += num;
        }

        double target = arrSum / 2.0;
        int count = 0;

        while (arrSum > target) {
            double largest = pq.poll();
            double half = largest / 2.0;
            arrSum -= half;
            pq.offer(half);
            count++;
        }

        return count;
    }
}
