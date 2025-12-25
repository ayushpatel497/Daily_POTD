class Solution:
    def findPeakGrid(self, mat):
        n = len(mat)
        m = len(mat[0])

        for i in range(n):
            for j in range(m):
                top = (i == 0) or (mat[i - 1][j] <= mat[i][j])
                bottom = (i == n - 1) or (mat[i + 1][j] <= mat[i][j])
                left = (j == 0) or (mat[i][j - 1] <= mat[i][j])
                right = (j == m - 1) or (mat[i][j + 1] <= mat[i][j])

                if top and bottom and left and right:
                    return [i, j]

        return []
