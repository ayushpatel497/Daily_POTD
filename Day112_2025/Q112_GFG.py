class Solution:
    def findUnique(self, arr):
        ans = 0
        for num in arr:
            ans ^= num
        return ans
