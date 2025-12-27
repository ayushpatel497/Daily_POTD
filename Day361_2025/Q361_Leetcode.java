import java.util.*;

class Q361_Leetcode {
    public int mostBooked(int n, int[][] meetings) {

        int[] meetingCount = new int[n];

        // usedRooms: (endTime, room)
        PriorityQueue<long[]> usedRooms = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );

        // unused rooms (min room number first)
        PriorityQueue<Integer> unusedRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            unusedRooms.offer(i);
        }

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            // Free rooms whose meetings have ended
            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
                int room = (int) usedRooms.poll()[1];
                unusedRooms.offer(room);
            }

            if (!unusedRooms.isEmpty()) {
                int room = unusedRooms.poll();
                usedRooms.offer(new long[]{end, room});
                meetingCount[room]++;
            } else {
                long[] top = usedRooms.poll();
                long availableTime = top[0];
                int room = (int) top[1];

                usedRooms.offer(new long[]{availableTime + (end - start), room});
                meetingCount[room]++;
            }
        }

        int maxCount = 0, ansRoom = 0;
        for (int i = 0; i < n; i++) {
            if (meetingCount[i] > maxCount) {
                maxCount = meetingCount[i];
                ansRoom = i;
            }
        }

        return ansRoom;
    }
}
