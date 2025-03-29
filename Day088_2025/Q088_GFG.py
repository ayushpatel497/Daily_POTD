from typing import List
from sortedcontainers import SortedSet

class Solution:
    def jobSequencing(self, deadline: List[int], profit: List[int]) -> List[int]:
        n = len(deadline)
        jobs = [(profit[i], deadline[i]) for i in range(n)]
        max_deadline = max(deadline)

        jobs.sort(reverse=True, key=lambda x: x[0])  # Sort by profit in descending order
        slots = SortedSet(range(1, max_deadline + 1))

        total_profit = 0
        job_count = 0

        for p, d in jobs:
            available_slot = slots.bisect_right(d)
            if available_slot > 0:
                total_profit += p
                job_count += 1
                slots.remove(slots[available_slot - 1])

        return [job_count, total_profit]

# Example Usage
sol = Solution()
deadlines = [2, 1, 2, 1, 3]
profits = [100, 50, 10, 20, 30]
print(sol.jobSequencing(deadlines, profits))  # Example Output
