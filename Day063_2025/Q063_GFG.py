import bisect

class Solution:
    def lis(self, arr):
        n = len(arr)
        ans = [arr[0]]

        for i in range(1, n):
            if arr[i] > ans[-1]:
                ans.append(arr[i])
            else:
                idx = bisect.bisect_left(ans, arr[i])
                ans[idx] = arr[i]

        return len(ans)
