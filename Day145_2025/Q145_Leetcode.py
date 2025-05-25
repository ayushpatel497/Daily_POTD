from typing import List


class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        count = [[0] * 26 for _ in range(26)]
        ans = 0

        for w in words:
            a = ord(w[0]) - ord('a')
            b = ord(w[1]) - ord('a')
            if count[b][a] > 0:
                ans += 4
                count[b][a] -= 1
            else:
                count[a][b] += 1

        # Check for one central palindromic pair like "aa", "bb", etc.
        for i in range(26):
            if count[i][i] > 0:
                ans += 2
                break

        return ans
