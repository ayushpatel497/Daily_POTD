from bisect import bisect_left, bisect_right

class Solution:
    def maxFrequency(self, nums, k, numOperations):
        nums.sort()
        ans = 0
        numCount = {}
        modes = set()

        def addMode(value):
            modes.add(value)
            if value - k >= nums[0]:
                modes.add(value - k)
            if value + k <= nums[-1]:
                modes.add(value + k)

        lastNumIndex = 0
        for i in range(len(nums)):
            if nums[i] != nums[lastNumIndex]:
                numCount[nums[lastNumIndex]] = i - lastNumIndex
                ans = max(ans, i - lastNumIndex)
                addMode(nums[lastNumIndex])
                lastNumIndex = i

        numCount[nums[lastNumIndex]] = len(nums) - lastNumIndex
        ans = max(ans, len(nums) - lastNumIndex)
        addMode(nums[lastNumIndex])

        for mode in sorted(modes):
            l = bisect_left(nums, mode - k)
            r = bisect_right(nums, mode + k) - 1

            if mode in numCount:
                tempAns = min(r - l + 1, numCount[mode] + numOperations)
            else:
                tempAns = min(r - l + 1, numOperations)

            ans = max(ans, tempAns)

        return ans
