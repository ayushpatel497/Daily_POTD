class Solution:
    def cntWays(self, arr):
        n = len(arr)
        evenSum = 0
        oddSum = 0

        # Total even and odd index sums
        for i in range(n):
            if i % 2 == 0:
                evenSum += arr[i]
            else:
                oddSum += arr[i]

        cnt = 0
        tEven = 0
        tOdd = 0

        for i in range(n):
            if i % 2 == 0:
                tEven += arr[i]
                x = oddSum - tOdd
                y = evenSum - tEven
                if x + tEven - arr[i] == tOdd + y:
                    cnt += 1
            else:
                tOdd += arr[i]
                x = oddSum - tOdd
                y = evenSum - tEven
                if x + tEven == tOdd + y - arr[i]:
                    cnt += 1

        return cnt
