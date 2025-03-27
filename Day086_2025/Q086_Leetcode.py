from typing import List

class Solution:
    def minimumIndex(self, nums: List[int]) -> int:
        x, count, xCount, n = nums[0], 0, 0, len(nums)

        # Find the dominant element
        for num in nums:
            if num == x:
                count += 1
            else:
                count -= 1
            if count == 0:
                x = num
                count = 1

        # Count occurrences of dominant element
        xCount = sum(1 for num in nums if num == x)

        count = 0
        for index in range(n):
            if nums[index] == x:
                count += 1
            remainingCount = xCount - count
            if count * 2 > index + 1 and remainingCount * 2 > n - index - 1:
                return index

        return -1

# Example Usage
nums = [1, 2, 2, 2, 3, 2, 2]
sol = Solution()
print(sol.minimumIndex(nums))  # Example Output
