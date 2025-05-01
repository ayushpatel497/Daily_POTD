from collections import deque
from typing import List

class Solution:
    def maxTaskAssign(self, tasks: List[int], workers: List[int], pills: int, strength: int) -> int:
        tasks.sort()
        workers.sort()
        n, m = len(tasks), len(workers)

        def can_assign(mid):
            p = pills
            dq = deque()
            ptr = m - 1
            for i in range(mid - 1, -1, -1):
                while ptr >= m - mid and workers[ptr] + strength >= tasks[i]:
                    dq.appendleft(workers[ptr])
                    ptr -= 1
                if not dq:
                    return False
                if dq[-1] >= tasks[i]:
                    dq.pop()
                else:
                    if p == 0:
                        return False
                    p -= 1
                    dq.popleft()
            return True

        left, right, ans = 1, min(n, m), 0
        while left <= right:
            mid = (left + right) // 2
            if can_assign(mid):
                ans = mid
                left = mid + 1
            else:
                right = mid - 1

        return ans
