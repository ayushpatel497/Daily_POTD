from typing import List


class Solution:
    def maxFreeTime(self, eventTime: int, startTime: List[int], endTime: List[int]) -> int:
        n = len(startTime)
        res = 0
        t1 = 0
        t2 = 0

        for i in range(n):
            left1 = 0 if i == 0 else endTime[i - 1]
            right1 = eventTime if i == n - 1 else startTime[i + 1]

            if endTime[i] - startTime[i] <= t1:
                res = max(res, right1 - left1)

            t1 = max(t1, startTime[i] - (0 if i == 0 else endTime[i - 1]))

            res = max(res, right1 - left1 - (endTime[i] - startTime[i]))

            idx = n - i - 1
            left2 = 0 if idx == 0 else endTime[idx - 1]
            right2 = eventTime if i == 0 else startTime[idx + 1]

            if endTime[idx] - startTime[idx] <= t2:
                res = max(res, right2 - left2)

            t2 = max(t2, (eventTime if i == 0 else startTime[idx + 1]) - endTime[idx])

        return res
