from collections import Counter
from typing import List

class FindSumPairs:

    def __init__(self, nums1: List[int], nums2: List[int]):
        self.nums1 = nums1
        self.nums2 = nums2
        self.count = Counter(nums2)

    def add(self, index: int, val: int) -> None:
        old_val = self.nums2[index]
        self.count[old_val] -= 1
        if self.count[old_val] == 0:
            del self.count[old_val]
        self.nums2[index] += val
        self.count[self.nums2[index]] += 1

    def count(self, tot: int) -> int:
        result = 0
        for num in self.nums1:
            complement = tot - num
            result += self.count.get(complement, 0)
        return result
