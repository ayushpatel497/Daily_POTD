class Solution:
    def missingNum(self, arr):
        n = len(arr) + 1
        xor_sum = 0
        
        for i in range(1, n + 1):
            xor_sum ^= i
            
        for num in arr:
            xor_sum ^= num
            
        return xor_sum
