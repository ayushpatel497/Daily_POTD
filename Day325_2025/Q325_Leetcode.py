class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:
        n = len(s)
        first = [float('inf')] * 26
        last = [-1] * 26

        # Record first and last occurrences
        for i, ch in enumerate(s):
            idx = ord(ch) - ord('a')
            first[idx] = min(first[idx], i)
            last[idx] = i

        ans = 0

        # Count distinct middle characters for each pair
        for i in range(26):
            if first[i] < last[i]:
                middle = set(s[first[i] + 1 : last[i]])
                ans += len(middle)

        return ans
