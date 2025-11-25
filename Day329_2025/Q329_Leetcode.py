class Solution:
    def smallestRepunitDivByK(self, k: int) -> int:
        # If K divisible by 2 or 5, impossible
        if k % 2 == 0 or k % 5 == 0:
            return -1
        
        remainder = 0
        for length_N in range(1, k + 1):
            remainder = (remainder * 10 + 1) % k
            if remainder == 0:
                return length_N
        
        return -1
