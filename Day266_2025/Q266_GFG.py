from collections import deque

class Solution:
    def reverseQueue(self, q: deque):
        if not q:
            return
        x = q.popleft()        # remove front
        self.reverseQueue(q)   # recurse
        q.append(x)            # add back
