class Solution:
    def powerfulInteger(self, intervals, k):
        n = len(intervals)
        start = [intervals[i][0] for i in range(n)]
        end = [intervals[i][1] for i in range(n)]

        start.sort()
        end.sort()

        ans = -1
        i = 0
        for j in range(n):
            while i < n and start[i] <= end[j]:
                i += 1
            if i - j >= k:
                ans = end[j]
        return ans
