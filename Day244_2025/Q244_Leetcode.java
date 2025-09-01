import java.util.*;

class Q244_Leetcode {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Lambda to calculate the profit of adding an extra student
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0])
        );

        double total = 0.0;
        for (int[] c : classes) {
            double pass = c[0], totalCls = c[1];
            double profit = (pass + 1) / (totalCls + 1) - pass / totalCls;
            pq.offer(new double[]{profit, pass, totalCls});
            total += pass / totalCls;
        }

        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            total += top[0]; // Add the profit
            double pass = top[1] + 1;
            double totalCls = top[2] + 1;
            double profit = (pass + 1) / (totalCls + 1) - pass / totalCls;
            pq.offer(new double[]{profit, pass, totalCls});
        }

        return total / classes.length;
    }
}
