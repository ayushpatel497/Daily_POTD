from typing import List

class Solution:
    def numOfSubarrays(self, arr: List[int]) -> int:
        MOD = 10**9 + 7
        count = 0
        prefix_sum = 0
        odd_count = 0
        even_count = 1  # accounts for initial prefix sum 0
        
        for num in arr:
            prefix_sum += num
            if prefix_sum % 2 == 0:
                count = (count + odd_count) % MOD
                even_count += 1
            else:
                count = (count + even_count) % MOD
                odd_count += 1
        
        return count
