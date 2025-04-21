from typing import List


class Solution:
    def numberOfArrays(self, differences: List[int], lower: int, upper: int) -> int:
        min_val = 0
        max_val = 0
        current = 0

        for diff in differences:
            current += diff
            min_val = min(min_val, current)
            max_val = max(max_val, current)

            if max_val - min_val > upper - lower:
                return 0

        return (upper - lower) - (max_val - min_val) + 1
