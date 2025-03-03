from collections import deque
from typing import List

class Solution:
    def longestSubarray(self, arr: List[int], x: int) -> List[int]:
        n, start, end = len(arr), 0, 0
        resStart, resEnd = 0, 0
        minQueue, maxQueue = deque(), deque()

        while end < n:
            while minQueue and arr[minQueue[-1]] > arr[end]:
                minQueue.pop()
            while maxQueue and arr[maxQueue[-1]] < arr[end]:
                maxQueue.pop()

            minQueue.append(end)
            maxQueue.append(end)

            while arr[maxQueue[0]] - arr[minQueue[0]] > x:
                if minQueue[0] == start:
                    minQueue.popleft()
                if maxQueue[0] == start:
                    maxQueue.popleft()
                start += 1

            if end - start > resEnd - resStart:
                resStart, resEnd = start, end

            end += 1

        return arr[resStart: resEnd + 1]
