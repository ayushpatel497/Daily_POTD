class Solution:
    def median(self, mat):
        val = []
        n, m = len(mat), len(mat[0])

        for i in range(n):
            for j in range(m):
                val.append(mat[i][j])

        val.sort()
        return val[(n * m) // 2]
