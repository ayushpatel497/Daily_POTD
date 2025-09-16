from typing import List
from math import gcd

class Solution:
    def replaceNonCoprimes(self, nums: List[int]) -> List[int]:
        stack = []
        
        for num in nums:
            while stack:
                top = stack[-1]
                g = gcd(top, num)
                if g == 1:
                    break
                stack.pop()
                num = (top * num) // g
            stack.append(num)
        
        return stack
