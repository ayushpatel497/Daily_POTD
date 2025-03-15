from typing import List

class Solution:
    def minCapability(self, nums: List[int], k: int) -> int:
        minReward, maxReward = 1, max(nums)
        totalHouses = len(nums)

        while minReward < maxReward:
            midReward = (minReward + maxReward) // 2
            possibleThefts = 0
            index = 0

            while index < totalHouses:
                if nums[index] <= midReward:
                    possibleThefts += 1
                    index += 1  # Skip the next house
                index += 1  # Move to the next house
            
            if possibleThefts >= k:
                maxReward = midReward
            else:
                minReward = midReward + 1

        return minReward
