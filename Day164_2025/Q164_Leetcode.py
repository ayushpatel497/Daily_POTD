class Solution:
    def countValidPairs(self, nums, threshold):
        index = 0
        count = 0
        while index < len(nums) - 1:
            if nums[index + 1] - nums[index] <= threshold:
                count += 1
                index += 1  # skip the paired element
            index += 1
        return count

    def minimizeMax(self, nums, p):
        nums.sort()
        left, right = 0, nums[-1] - nums[0]

        while left < right:
            mid = (left + right) // 2
            if self.countValidPairs(nums, mid) >= p:
                right = mid
            else:
                left = mid + 1

        return left
