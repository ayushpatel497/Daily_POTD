import heapq
from typing import List

class Solution:
    def maxEvents(self, events: List[List[int]]) -> int:
        events.sort()
        n = len(events)
        max_day = max(e[1] for e in events)
        pq = []
        res = 0
        i = 0

        for day in range(1, max_day + 1):
            # Add events that start today
            while i < n and events[i][0] == day:
                heapq.heappush(pq, events[i][1])
                i += 1

            # Remove past events
            while pq and pq[0] < day:
                heapq.heappop(pq)

            # Attend one event
            if pq:
                heapq.heappop(pq)
                res += 1

        return res
