class Solution:
    def constructArr(self, arr):
        n = int((len(arr) * 2) ** 0.5) + 1
        res = [0] * n

        res[0] = (arr[0] + arr[1] - arr[n - 1]) // 2

        for i in range(1, n):
            res[i] = arr[i - 1] - res[0]

        return res
