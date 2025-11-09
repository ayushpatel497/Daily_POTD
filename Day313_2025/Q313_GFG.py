class Solution:
    def chocolatePickup(self, mat):
        n, m = len(mat), len(mat[0])
        curr = [[0] * m for _ in range(m)]
        next_ = [[0] * m for _ in range(m)]

        for i1 in range(n - 1, -1, -1):
            curr = [[0] * m for _ in range(m)]
            for j1 in range(m - 1, -1, -1):
                for j2 in range(m - 1, -1, -1):
                    if i1 == n - 1 and j1 == m - 1 and j2 == m - 1:
                        curr[m - 1][m - 1] = -1 if mat[n - 1][m - 1] == -1 else mat[n - 1][m - 1]
                        continue

                    i2 = i1 + j1 - j2
                    if i2 >= n or i2 < 0:
                        continue

                    ans = -1
                    dirs = [(1, 0), (0, 1)]
                    for d1 in dirs:
                        for d2 in dirs:
                            newRow1, newCol1 = i1 + d1[0], j1 + d1[1]
                            newRow2, newCol2 = i2 + d2[0], j2 + d2[1]
                            if (newRow1 < n and newRow2 < n and
                                newCol1 < m and newCol2 < m and
                                mat[newRow1][newCol1] != -1 and mat[newRow2][newCol2] != -1):
                                if newRow1 == i1 + 1:
                                    ans = max(ans, next_[newCol1][newCol2])
                                else:
                                    ans = max(ans, curr[newCol1][newCol2])

                    if ans == -1 or mat[i1][j1] == -1 or mat[i2][j2] == -1:
                        curr[j1][j2] = -1
                        continue

                    ans += mat[i1][j1]
                    if i1 != i2 and mat[i2][j2] != -1:
                        ans += mat[i2][j2]

                    curr[j1][j2] = ans
            next_ = curr
        return max(0, next_[0][0])
