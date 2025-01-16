class Solution:
    def maxLen(self, arr):
        # Q. Largest subarray of 0's and 1's
        # Your code here
        preSumIndexMap = {}
        answerLength = 0
        preSum = 0

        for index in range(len(arr)):
            preSum += 1 if arr[index] == 1 else -1

            if preSum == 0:
                answerLength = index + 1

            if preSum in preSumIndexMap:
                answerLength = max(answerLength, index - preSumIndexMap[preSum])
            else:
                preSumIndexMap[preSum] = index

        return answerLength


if __name__ == "__main__":
    T = int(input())
    for _ in range(T):
        arr = list(map(int, input().split()))
        sol = Solution()
        print(sol.maxLen(arr))
