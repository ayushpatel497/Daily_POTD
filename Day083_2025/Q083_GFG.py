class Solution:
    def matrixMultiplication(self, arr):
        arr_size = len(arr)
        dp = [[0] * arr_size for _ in range(arr_size)]

        for length in range(2, arr_size):
            for start in range(1, arr_size - length + 1):
                end = start + length - 1
                minimum = float('inf')

                for index in range(start, end):
                    cost = dp[start][index] + dp[index + 1][end] + arr[start - 1] * arr[index] * arr[end]
                    minimum = min(minimum, cost)

                dp[start][end] = minimum

        return dp[1][arr_size - 1]
