class Solution:
    def countWays(self, n: int) -> int:
        # Base cases
        if n == 1 or n == 2:
            return n
        
        prev2, prev1 = 1, 2
        
        for _ in range(3, n + 1):
            prev1, prev2 = prev1 + prev2, prev1
        
        return prev1
