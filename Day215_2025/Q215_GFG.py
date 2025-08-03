class Solution:
    def applyDiff2D(self, mat, opr):
        n, m = len(mat), len(mat[0])
        temp = [[0] * m for _ in range(n)]

        for x in opr:
            val, r1, c1, r2, c2 = x
            temp[r2][c2] += val

            if r1 - 1 >= 0 and c1 - 1 >= 0:
                temp[r1 - 1][c1 - 1] += val

            if c1 - 1 >= 0:
                temp[r2][c1 - 1] -= val

            if r1 - 1 >= 0:
                temp[r1 - 1][c2] -= val

        for i in range(n):
            for j in range(m - 2, -1, -1):
                temp[i][j] += temp[i][j + 1]

        for i in range(n - 2, -1, -1):
            for j in range(m):
                temp[i][j] += temp[i + 1][j]

        for i in range(n):
            for j in range(m):
                temp[i][j] += mat[i][j]

        return temp
