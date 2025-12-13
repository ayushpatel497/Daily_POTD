class Solution:
    def swapDiagonal(self, mat):
        n = len(mat)
        j = n - 1

        for i in range(n):
            mat[i][i], mat[i][j] = mat[i][j], mat[i][i]
            j -= 1
