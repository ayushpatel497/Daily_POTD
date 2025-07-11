import java.util.*;

class Q192_Leetcode {
    public int mostBooked(int n, int[][] meetings) {
        int[] meetingCount = new int[n];
        PriorityQueue<long[]> usedRooms = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        PriorityQueue<Integer> unusedRooms = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            unusedRooms.offer(i);
        }

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            // Free up rooms whose end time has passed
            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
                int room = (int) usedRooms.poll()[1];
                unusedRooms.offer(room);
            }

            if (!unusedRooms.isEmpty()) {
                int room = unusedRooms.poll();
                usedRooms.offer(new long[] {end, room});
                meetingCount[room]++;
            } else {
                long[] earliest = usedRooms.poll();
                long roomAvailableTime = earliest[0];
                int room = (int) earliest[1];
                long newEnd = roomAvailableTime + (end - start);
                usedRooms.offer(new long[] {newEnd, room});
                meetingCount[room]++;
            }
        }

        int maxMeetings = 0, answerRoom = 0;
        for (int i = 0; i < n; i++) {
            if (meetingCount[i] > maxMeetings) {
                maxMeetings = meetingCount[i];
                answerRoom = i;
            }
        }

        return answerRoom;
    }
}
