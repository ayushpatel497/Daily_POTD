class Solution:
    def lcs(self, s1: str, s2: str) -> int:
        n, m = len(s1), len(s2)
        
        next_row = [0] * (m + 1)
        cur = [0] * (m + 1)

        for i in range(n - 1, -1, -1):
            for j in range(m - 1, -1, -1):
                if s1[i] == s2[j]:
                    cur[j] = 1 + next_row[j + 1]
                else:
                    cur[j] = max(next_row[j], cur[j + 1])
            next_row = cur[:]

        return next_row[0]
