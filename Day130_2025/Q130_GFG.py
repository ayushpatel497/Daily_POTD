class Solution:
    def longestSubarray(self, arr, k):
        n = len(arr)
        temp = [1 if val > k else -1 for val in arr]

        csum = 0
        index = {}
        ans = 0

        for i in range(n):
            csum += temp[i]
            if csum > 0:
                ans = i + 1
            elif (csum - 1) in index:
                ans = max(ans, i - index[csum - 1])
            if csum not in index:
                index[csum] = i

        return ans
