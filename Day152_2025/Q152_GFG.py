class Solution:
    def countPairs(self, mat1, mat2, x):
        n = len(mat1)
        i, j = 0, n * n - 1
        count = 0

        while i < n * n and j >= 0:
            r1, c1 = divmod(i, n)
            r2, c2 = divmod(j, n)
            val = mat1[r1][c1] + mat2[r2][c2]

            if val == x:
                count += 1
                i += 1
                j -= 1
            elif val < x:
                i += 1
            else:
                j -= 1

        return count
