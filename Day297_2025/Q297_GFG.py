from collections import defaultdict

class Solution:
    def isPossible(self, arr, k):
        freq = defaultdict(int)
        skip = defaultdict(int)

        for num in arr:
            freq[num] += 1

        for num in arr:
            if skip[num] > 0 or freq[num - 1] > 0:
                continue
            start = num
            while freq[start] > 0:
                freq[start] -= 1
                if start != num:
                    skip[start] += 1
                start += 1
            if (start - num) < k:
                return False
        return True
