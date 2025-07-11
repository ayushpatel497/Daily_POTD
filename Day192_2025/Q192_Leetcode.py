import heapq
from typing import List

class Solution:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        meeting_count = [0] * n
        used_rooms = []  # min-heap of (endTime, room)
        unused_rooms = list(range(n))  # available rooms
        heapq.heapify(unused_rooms)

        meetings.sort()

        for start, end in meetings:
            # Free up rooms
            while used_rooms and used_rooms[0][0] <= start:
                _, room = heapq.heappop(used_rooms)
                heapq.heappush(unused_rooms, room)

            if unused_rooms:
                room = heapq.heappop(unused_rooms)
                heapq.heappush(used_rooms, (end, room))
                meeting_count[room] += 1
            else:
                end_time, room = heapq.heappop(used_rooms)
                new_end = end_time + (end - start)
                heapq.heappush(used_rooms, (new_end, room))
                meeting_count[room] += 1

        max_meetings = max(meeting_count)
        for i in range(n):
            if meeting_count[i] == max_meetings:
                return i
