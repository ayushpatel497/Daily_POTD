import java.util.*;

class Q188_Leetcode {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);  // sort by start day
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap of end days

        int i = 0, n = events.length, res = 0;
        int day = 0;
        
        // Find the last day any event ends
        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }

        for (day = 1; day <= maxDay; day++) {
            // Push events starting today
            while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }

            // Remove events that have already expired
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            // Attend one event today
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
        }

        return res;
    }
}
