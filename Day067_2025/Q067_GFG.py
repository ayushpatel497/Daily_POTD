class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        if n == 0:
            return ""

        start, max_len = 0, 1

        for i in range(n):
            for j in range(2):  # j=0 for odd-length, j=1 for even-length
                low, high = i, i + j
                while low >= 0 and high < n and s[low] == s[high]:
                    curr_len = high - low + 1
                    if curr_len > max_len:
                        start = low
                        max_len = curr_len
                    low -= 1
                    high += 1

        return s[start:start + max_len]
