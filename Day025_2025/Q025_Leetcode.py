from collections import defaultdict, deque
from typing import List

class Solution:
    def lexicographicallySmallestArray(self, nums: List[int], limit: int) -> List[int]:
        nums_sorted = sorted(nums)
        num_to_group = {}
        group_to_list = defaultdict(deque)

        curr_group = 0
        num_to_group[nums_sorted[0]] = curr_group
        group_to_list[curr_group].append(nums_sorted[0])

        for i in range(1, len(nums_sorted)):
            if abs(nums_sorted[i] - nums_sorted[i - 1]) > limit:
                curr_group += 1
            num_to_group[nums_sorted[i]] = curr_group
            group_to_list[curr_group].append(nums_sorted[i])

        for i in range(len(nums)):
            group = num_to_group[nums[i]]
            nums[i] = group_to_list[group].popleft()

        return nums
