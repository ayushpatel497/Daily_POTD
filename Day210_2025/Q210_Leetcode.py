class Solution:
    def smallestSubarrays(self, nums):
        n = len(nums)
        pos = [-1] * 31
        ans = [0] * n

        for i in range(n - 1, -1, -1):
            j = i
            for b in range(31):
                if nums[i] & (1 << b):
                    pos[b] = i           # bit present at i
                elif pos[b] != -1:
                    j = max(j, pos[b])   # must extend to include this bit
            ans[i] = j - i + 1
        return ans
