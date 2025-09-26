from collections import deque

class Solution:    
    def rotateDeque(self, dq: deque, type: int, k: int):
        if type == 1:  # rotate right
            for _ in range(k):
                val = dq.pop()
                dq.appendleft(val)
        elif type == 2:  # rotate left
            for _ in range(k):
                val = dq.popleft()
                dq.append(val)
