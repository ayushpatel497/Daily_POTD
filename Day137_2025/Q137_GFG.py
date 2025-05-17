class Solution:
    def sortArray(self, arr, A, B, C):
        def evaluate(x):
            return A * x * x + B * x + C

        n = len(arr)
        res = [0] * n
        left, right = 0, n - 1
        index = n - 1 if A >= 0 else 0

        while left <= right:
            leftVal = evaluate(arr[left])
            rightVal = evaluate(arr[right])

            if A >= 0:
                if leftVal > rightVal:
                    res[index] = leftVal
                    left += 1
                else:
                    res[index] = rightVal
                    right -= 1
                index -= 1
            else:
                if leftVal < rightVal:
                    res[index] = leftVal
                    left += 1
                else:
                    res[index] = rightVal
                    right -= 1
                index += 1

        return res
