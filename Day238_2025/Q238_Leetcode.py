from typing import List

class Solution:
    def areaOfMaxDiagonal(self, dimensions: List[List[int]]) -> int:
        maxDiaSq, maxArea = 0, 0
        
        for l, w in dimensions:
            diaSq = l * l + w * w
            area = l * w
            
            if diaSq > maxDiaSq:
                maxDiaSq = diaSq
                maxArea = area
            elif diaSq == maxDiaSq:
                maxArea = max(maxArea, area)
        
        return maxArea
