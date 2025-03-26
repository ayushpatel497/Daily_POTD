from typing import List

class Solution:
    def minOperations(self, grid: List[List[int]], x: int) -> int:
        numsArray = []
        
        # Flatten the grid and check divisibility
        base_mod = grid[0][0] % x
        for row in grid:
            for num in row:
                if num % x != base_mod:
                    return -1  # If mod values don't match, return -1
                numsArray.append(num)

        # Sort the array to find the median
        numsArray.sort()
        median = numsArray[len(numsArray) // 2]
        result = sum(abs(num - median) // x for num in numsArray)

        return result
