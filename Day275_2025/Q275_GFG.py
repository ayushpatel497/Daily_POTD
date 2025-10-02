class Solution:
    def combinationSum(self, n, k):
        result = []

        def backtrack(start, k, target, current):
            if k == 0 and target == 0:
                result.append(list(current))
                return
            if k == 0 or target <= 0:
                return

            for i in range(start, 10):
                current.append(i)
                backtrack(i + 1, k - 1, target - i, current)
                current.pop()

        backtrack(1, k, n, [])
        return result
