class Solution:
    def setMatrixZeroes(self, mat):
        n = len(mat)
        m = len(mat[0])
        zero_positions = []

        for i in range(n):
            for j in range(m):
                if mat[i][j] == 0:
                    zero_positions.append((i, j))

        for r, c in zero_positions:
            for i in range(m):
                mat[r][i] = 0
            for i in range(n):
                mat[i][c] = 0
