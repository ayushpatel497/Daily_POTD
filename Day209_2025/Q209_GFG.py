class Solution:
    def balanceSums(self, mat):
        n = len(mat)
        maxe = float('-inf')

        # Find max of all row and column sums
        for i in range(n):
            rowSum = sum(mat[i])
            colSum = sum(mat[j][i] for j in range(n))
            maxe = max(maxe, rowSum, colSum)

        # Total operations needed to make every row sum equal to maxe
        ans = 0
        for i in range(n):
            rowSum = sum(mat[i])
            ans += maxe - rowSum

        return ans
