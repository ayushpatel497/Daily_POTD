from collections import deque

class Solution:
    def countPartitions(self, nums, k: int) -> int:
        n = len(nums)
        mod = 10**9 + 7

        dp = [0] * (n + 1)
        prefix = [0] * (n + 1)

        minQ = deque()
        maxQ = deque()

        dp[0] = 1
        prefix[0] = 1

        j = 0

        for i in range(n):

            # maintain max deque
            while maxQ and nums[maxQ[-1]] <= nums[i]:
                maxQ.pop()
            maxQ.append(i)

            # maintain min deque
            while minQ and nums[minQ[-1]] >= nums[i]:
                minQ.pop()
            minQ.append(i)

            # shrink window
            while maxQ and minQ and nums[maxQ[0]] - nums[minQ[0]] > k:
                if maxQ[0] == j:
                    maxQ.popleft()
                if minQ[0] == j:
                    minQ.popleft()
                j += 1

            val = prefix[i] - (prefix[j - 1] if j > 0 else 0)
            val = (val + mod) % mod

            dp[i + 1] = val
            prefix[i + 1] = (prefix[i] + dp[i + 1]) % mod

        return dp[n]
