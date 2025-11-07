from bisect import bisect_right

class Solution:
    def maxProfit(self, jobs):
        # Sort jobs by end time
        jobs.sort(key=lambda x: x[1])
        n = len(jobs)

        endTimes = [job[1] for job in jobs]
        dp = [0] * n
        dp[0] = jobs[0][2]

        for i in range(1, n):
            profitInclude = jobs[i][2]

            # Find index of last job that ends before current job starts
            idx = bisect_right(endTimes, jobs[i][0]) - 1
            if idx >= 0:
                profitInclude += dp[idx]

            profitExclude = dp[i - 1]
            dp[i] = max(profitInclude, profitExclude)

        return dp[-1]
