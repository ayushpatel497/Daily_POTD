from collections import deque
import bisect
from typing import List

class Router:
    def __init__(self, memoryLimit: int):
        self.mpp = {}
        self.queue = deque()
        self.timestamps = {}
        self.st = {}
        self.maxSize = memoryLimit

    def addPacket(self, source: int, destination: int, timestamp: int) -> bool:
        packet = (source, destination, timestamp)
        if packet in self.mpp:
            return False

        if len(self.queue) == self.maxSize:
            res = self.queue.popleft()
            self.mpp.pop(res, None)
            temp = res[1]
            self.st[temp] = self.st.get(temp, 0) + 1

        self.queue.append(packet)
        self.mpp[packet] = 1
        if destination not in self.timestamps:
            self.timestamps[destination] = []
        self.timestamps[destination].append(timestamp)
        return True

    def forwardPacket(self) -> List[int]:
        if not self.queue:
            return []
        res = self.queue.popleft()
        self.mpp.pop(res, None)
        temp = res[1]
        self.st[temp] = self.st.get(temp, 0) + 1
        return list(res)

    def getCount(self, destination: int, startTime: int, endTime: int) -> int:
        if destination not in self.timestamps:
            return 0
        p = self.timestamps[destination]
        temp = self.st.get(destination, 0)

        right = bisect.bisect_left(p, startTime, lo=temp)
        left = bisect.bisect_right(p, endTime, lo=temp)

        return left - right
