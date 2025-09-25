from collections import deque

class Solution:
    def generateBinary(self, n):
        res = []
        q = deque()
        q.append("1")

        while n > 0:
            s1 = q.popleft()
            res.append(s1)

            q.append(s1 + "0")
            q.append(s1 + "1")
            n -= 1

        return res
