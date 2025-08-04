class Solution:
    def maxRectSum(self, mat):
        n = len(mat)
        m = len(mat[0])
        max_sum = float('-inf')

        for left in range(m):
            temp = [0] * n

            for right in range(left, m):
                for i in range(n):
                    temp[i] += mat[i][right]

                # Apply Kadane's algorithm
                curr_sum = 0
                best = float('-inf')
                for val in temp:
                    curr_sum += val
                    best = max(best, curr_sum)
                    if curr_sum < 0:
                        curr_sum = 0

                max_sum = max(max_sum, best)

        return max_sum
