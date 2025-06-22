class Solution:
    def largestSubset(self, arr):
        n = len(arr)
        arr.sort()
        dp = [1] * n
        parent = [-1] * n
        max_len = 0
        max_idx = -1

        for i in range(n):
            for j in range(i):
                if arr[i] % arr[j] == 0 and dp[i] < dp[j] + 1:
                    dp[i] = dp[j] + 1
                    parent[i] = j
            if dp[i] > max_len:
                max_len = dp[i]
                max_idx = i

        result = []
        while max_idx != -1:
            result.append(arr[max_idx])
            max_idx = parent[max_idx]
        result.reverse()
        return result
