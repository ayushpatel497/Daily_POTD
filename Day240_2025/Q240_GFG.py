class Solution:
    def maxOnes(self, arr, k):
        left = 0
        zeroCount = 0
        maxLen = 0

        for right in range(len(arr)):
            if arr[right] == 0:
                zeroCount += 1

            while zeroCount > k:
                if arr[left] == 0:
                    zeroCount -= 1
                left += 1

            maxLen = max(maxLen, right - left + 1)

        return maxLen
