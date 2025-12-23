from typing import List

class Solution:
    def maxTwoEvents(self, events: List[List[int]]) -> int:
        events.sort(key=lambda x: x[0])
        n = len(events)

        # Suffix max array
        suffix_max = [0] * n
        suffix_max[-1] = events[-1][2]

        for i in range(n - 2, -1, -1):
            suffix_max[i] = max(events[i][2], suffix_max[i + 1])

        max_sum = 0

        for i in range(n):
            left, right = i + 1, n - 1
            next_index = -1

            # Binary search
            while left <= right:
                mid = (left + right) // 2
                if events[mid][0] > events[i][1]:
                    next_index = mid
                    right = mid - 1
                else:
                    left = mid + 1

            if next_index != -1:
                max_sum = max(max_sum, events[i][2] + suffix_max[next_index])

            max_sum = max(max_sum, events[i][2])

        return max_sum
