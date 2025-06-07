class Solution:
    def longestCommonSum(self, a1, a2):
        n = len(a1)
        diff = [-1] * (2 * n + 1)
        sum1 = sum2 = res = 0

        for i in range(n):
            sum1 += a1[i]
            sum2 += a2[i]
            currentDiff = sum1 - sum2
            index = currentDiff + n

            if currentDiff == 0:
                res = max(res, i + 1)
            elif diff[index] != -1:
                res = max(res, i - diff[index])
            else:
                diff[index] = i

        return res
