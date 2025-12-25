import java.util.*;

class Q359_Leetcode {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int h : happiness) {
            pq.add(h);
        }

        long totalHappinessSum = 0;
        int turns = 0;

        for (int i = 0; i < k; i++) {
            int top = pq.poll();
            totalHappinessSum += Math.max(top - turns, 0);
            turns++;
        }

        return totalHappinessSum;
    }
}
