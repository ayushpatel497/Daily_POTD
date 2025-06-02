from typing import List


class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        candy = n
        i = 1

        while i < n:
            if ratings[i] == ratings[i - 1]:
                i += 1
                continue

            peak = 0
            while i < n and ratings[i] > ratings[i - 1]:
                peak += 1
                candy += peak
                i += 1

            valley = 0
            while i < n and ratings[i] < ratings[i - 1]:
                valley += 1
                candy += valley
                i += 1

            candy -= min(peak, valley)

        return candy
