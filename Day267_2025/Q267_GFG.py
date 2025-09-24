from collections import deque

class SpecialQueue:
    def __init__(self):
        self.q = deque()
        self.minQ = deque()
        self.maxQ = deque()

    def enqueue(self, x: int) -> None:
        self.q.append(x)

        while self.minQ and self.minQ[-1] > x:
            self.minQ.pop()
        self.minQ.append(x)

        while self.maxQ and self.maxQ[-1] < x:
            self.maxQ.pop()
        self.maxQ.append(x)

    def dequeue(self) -> None:
        if not self.q:
            return
        val = self.q.popleft()
        if self.minQ and self.minQ[0] == val:
            self.minQ.popleft()
        if self.maxQ and self.maxQ[0] == val:
            self.maxQ.popleft()

    def getFront(self) -> int:
        return self.q[0]

    def getMin(self) -> int:
        return self.minQ[0]

    def getMax(self) -> int:
        return self.maxQ[0]
