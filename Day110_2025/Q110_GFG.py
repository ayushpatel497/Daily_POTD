class Solution:
    def findDuplicate(self, arr):
        ans = 0
        n = len(arr)  # elements from 1 to n-1
        
        for num in arr:
            ans ^= num
        
        for i in range(1, n):
            ans ^= i
        
        return ans
