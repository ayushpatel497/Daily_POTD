from collections import deque

class Solution:
    def maxSubarrSum(self, arr, a, b):
        n = len(arr)
        ans = float("-inf")

        pre = [0] * (n + 1)
        for i in range(1, n + 1):
            pre[i] = pre[i - 1] + arr[i - 1]

        q = deque()

        for i in range(a, n + 1):
            # remove indices out of window
            while q and q[0] + b < i:
                q.popleft()

            # maintain increasing order of prefix sums
            while q and pre[q[-1]] > pre[i - a]:
                q.pop()

            q.append(i - a)

            ans = max(ans, pre[i] - pre[q[0]])

        return ans
