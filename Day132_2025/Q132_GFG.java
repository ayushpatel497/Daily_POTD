import java.util.*;

class Q132_GFG {
    public int mostBooked(int n, int[][] meetings) {
        int[] count = new int[n];
        PriorityQueue<long[]> ongoing = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0])); // [endTime, room]
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n; i++) available.offer(i);

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        for (int[] m : meetings) {
            int start = m[0], end = m[1];
            while (!ongoing.isEmpty() && ongoing.peek()[0] <= start) {
                available.offer((int) ongoing.poll()[1]);
            }

            if (!available.isEmpty()) {
                int room = available.poll();
                ongoing.offer(new long[]{end, room});
                count[room]++;
            } else {
                long[] meeting = ongoing.poll();
                long endTime = meeting[0];
                int room = (int) meeting[1];
                ongoing.offer(new long[]{endTime + (end - start), room});
                count[room]++;
            }
        }

        int maxCount = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                res = i;
            }
        }

        return res;
    }
}
