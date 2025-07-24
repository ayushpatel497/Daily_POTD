class Solution:
    def getLastMoment(self, n, left, right):
        max_time = 0

        for ant in left:
            max_time = max(max_time, ant)

        for ant in right:
            max_time = max(max_time, n - ant)

        return max_time
