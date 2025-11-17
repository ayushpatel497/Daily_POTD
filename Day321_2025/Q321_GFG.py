class Solution:
    def maxSumIS(self, arr):
        n = len(arr)
        curr = [0] * (n + 1)
        next = [0] * (n + 1)

        for currIndex in range(n - 1, -1, -1):
            for lastIndex in range(currIndex - 1, -1, -1):
                notTake = next[lastIndex + 1]
                take = 0

                if lastIndex == -1 or arr[currIndex] > arr[lastIndex]:
                    take = arr[currIndex] + next[currIndex + 1]

                curr[lastIndex + 1] = max(notTake, take)

            # handle lastIndex = -1 case separately
            notTake = next[0]
            take = arr[currIndex] + next[currIndex + 1]
            curr[0] = max(notTake, take)

            next = curr[:]

        return next[0]
