class Solution:
    def substrCount(self, s, k):
        def is_valid(temp, val):
            freq = [0] * 26
            unique = 0
            for ch in temp:
                idx = ord(ch) - ord('a')
                if freq[idx] == 0:
                    unique += 1
                freq[idx] += 1
            return unique == val

        n = len(s)
        if k > n:
            return 0

        ans = 0
        for i in range(n - k + 1):
            temp = s[i:i + k]
            if is_valid(temp, k - 1):
                ans += 1
        return ans
