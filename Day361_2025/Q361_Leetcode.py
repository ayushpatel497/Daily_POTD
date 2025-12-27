import heapq
from typing import List

class Solution:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        meetingCount = [0] * n

        # (endTime, room)
        usedRooms = []

        # available rooms
        unusedRooms = list(range(n))
        heapq.heapify(unusedRooms)

        meetings.sort()

        for start, end in meetings:

            # free rooms
            while usedRooms and usedRooms[0][0] <= start:
                _, room = heapq.heappop(usedRooms)
                heapq.heappush(unusedRooms, room)

            if unusedRooms:
                room = heapq.heappop(unusedRooms)
                heapq.heappush(usedRooms, (end, room))
                meetingCount[room] += 1
            else:
                availTime, room = heapq.heappop(usedRooms)
                heapq.heappush(usedRooms, (availTime + end - start, room))
                meetingCount[room] += 1

        maxCount = 0
        ansRoom = 0
        for i in range(n):
            if meetingCount[i] > maxCount:
                maxCount = meetingCount[i]
                ansRoom = i

        return ansRoom
