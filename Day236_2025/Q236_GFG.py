from typing import List

class Solution:
    def minDaysBloom(self, arr: List[int], k: int, m: int) -> int:
        arr.sort()
        if len(arr) < m * k:
            return -1
        return arr[m * k - 1]
