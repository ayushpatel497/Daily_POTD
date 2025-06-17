import bisect

class Solution:
    def minimumCoins(self, arr, k):
        arr.sort()
        n = len(arr)
        pre = [0] * (n + 1)
        
        for i in range(1, n + 1):
            pre[i] = pre[i - 1] + arr[i - 1]
        
        ans = float('inf')
        
        for i in range(n):
            high = arr[i] + k
            ub = bisect.bisect_right(arr, high)
            cost = pre[i] + (pre[n] - pre[ub]) - (n - ub) * high
            ans = min(ans, cost)
        
        return ans
