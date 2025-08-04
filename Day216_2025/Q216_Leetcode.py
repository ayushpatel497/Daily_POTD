from typing import List


class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        from collections import defaultdict

        count = defaultdict(int)
        i = 0
        res = 0

        for j in range(len(fruits)):
            count[fruits[j]] += 1

            while len(count) > 2:
                count[fruits[i]] -= 1
                if count[fruits[i]] == 0:
                    del count[fruits[i]]
                i += 1

            res = max(res, j - i + 1)

        return res
