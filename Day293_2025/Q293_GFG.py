class Solution:
    def countBSTs(self, arr):
        n = len(arr)
        numWays = [0] * 7
        numWays[0] = numWays[1] = 1

        for index in range(2, len(numWays)):
            left, right, total = 0, index - 1, 0
            while left <= right:
                product = numWays[left] * numWays[right]
                total += product * (1 + (left != right))
                left += 1
                right -= 1
            numWays[index] = total

        valueToIndex = {arr[i]: i for i in range(n)}
        sortedInput = sorted(arr)

        result = [0] * n
        for index in range(n):
            original = valueToIndex[sortedInput[index]]
            result[original] = numWays[index] * numWays[n - index - 1]

        return result
