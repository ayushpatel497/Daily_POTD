from typing import List

class Solution:
    def maxSubsequence(self, nums: List[int], k: int) -> List[int]:
        indexed = list(enumerate(nums))
        indexed.sort(key=lambda x: -x[1])  # Sort by value descending
        top_k = sorted(indexed[:k], key=lambda x: x[0])  # Sort by original index
        return [x[1] for x in top_k]
