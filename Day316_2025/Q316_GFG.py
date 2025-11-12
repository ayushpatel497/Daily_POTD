class Solution:
    def wildCard(self, txt, pat):
        from functools import lru_cache

        @lru_cache(None)
        def solve(i, j):
            if i == len(txt) and j == len(pat):
                return True
            if j == len(pat):
                return False
            if i == len(txt):
                return all(ch == '*' for ch in pat[j:])

            if pat[j] == '?':
                return solve(i + 1, j + 1)
            elif pat[j] == '*':
                return solve(i + 1, j + 1) or solve(i, j + 1) or solve(i + 1, j)
            else:
                return txt[i] == pat[j] and solve(i + 1, j + 1)

        return solve(0, 0)
