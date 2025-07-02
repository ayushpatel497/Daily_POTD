from collections import defaultdict

class Solution:
    def totalElements(self, arr):
        n = len(arr)
        if n <= 2:
            return n

        freq = defaultdict(int)
        left = 0
        res = 0

        for right in range(n):
            freq[arr[right]] += 1

            while len(freq) > 2:
                freq[arr[left]] -= 1
                if freq[arr[left]] == 0:
                    del freq[arr[left]]
                left += 1

            res = max(res, right - left + 1)

        return res
