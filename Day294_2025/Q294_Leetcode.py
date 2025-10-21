from typing import List


class Solution:
    def maxFrequency(self, nums: List[int], k: int, numOperations: int) -> int:
        nums.sort()
        ans = 0
        numCount = {}
        lastNumIndex = 0

        for i in range(len(nums)):
            if nums[i] != nums[lastNumIndex]:
                numCount[nums[lastNumIndex]] = i - lastNumIndex
                ans = max(ans, i - lastNumIndex)
                lastNumIndex = i

        numCount[nums[lastNumIndex]] = len(nums) - lastNumIndex
        ans = max(ans, len(nums) - lastNumIndex)

        def leftBound(value):
            left, right = 0, len(nums) - 1
            while left < right:
                mid = (left + right) // 2
                if nums[mid] < value:
                    left = mid + 1
                else:
                    right = mid
            return left

        def rightBound(value):
            left, right = 0, len(nums) - 1
            while left < right:
                mid = (left + right + 1) // 2
                if nums[mid] > value:
                    right = mid - 1
                else:
                    left = mid
            return left

        for i in range(nums[0], nums[-1] + 1):
            l = leftBound(i - k)
            r = rightBound(i + k)
            if i in numCount:
                tempAns = min(r - l + 1, numCount[i] + numOperations)
            else:
                tempAns = min(r - l + 1, numOperations)
            ans = max(ans, tempAns)

        return ans
