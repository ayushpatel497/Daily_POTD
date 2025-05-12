import heapq

class Solution:
    def mostBooked(self, n, meetings):
        count = [0] * n
        ongoing = []  # [endTime, room]
        available = list(range(n))
        heapq.heapify(available)
        
        meetings.sort()
        
        for start, end in meetings:
            while ongoing and ongoing[0][0] <= start:
                _, room = heapq.heappop(ongoing)
                heapq.heappush(available, room)

            if available:
                room = heapq.heappop(available)
                heapq.heappush(ongoing, (end, room))
                count[room] += 1
            else:
                endTime, room = heapq.heappop(ongoing)
                newEnd = endTime + (end - start)
                heapq.heappush(ongoing, (newEnd, room))
                count[room] += 1

        max_count = max(count)
        for i in range(n):
            if count[i] == max_count:
                return i
