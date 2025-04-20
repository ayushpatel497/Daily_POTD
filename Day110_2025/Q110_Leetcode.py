from typing import List
from math import ceil
from collections import Counter

class Solution:
    def numRabbits(self, answers: List[int]) -> int:
        freq = Counter(answers)
        total = 0

        for x, count in freq.items():
            group_size = x + 1
            groups = ceil(count / group_size)
            total += groups * group_size

        return total
