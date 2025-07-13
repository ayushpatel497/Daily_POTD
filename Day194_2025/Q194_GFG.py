class Solution:
    def nonLisMaxSum(self, arr):
        n = len(arr)
        dp = [1] * n
        temp = list(range(n))  # initially each element points to itself

        for i in range(n):
            for j in range(i):
                if arr[j] < arr[i] and dp[i] <= dp[j] + 1:
                    dp[i] = dp[j] + 1
                    temp[i] = j

        total = sum(arr)
        max_len = max(dp)
        index = -1
        for i in range(n):
            if dp[i] == max_len:
                index = i

        lis_sum = arr[index]
        max_len -= 1
        while max_len > 0:
            index = temp[index]
            lis_sum += arr[index]
            max_len -= 1

        return total - lis_sum
