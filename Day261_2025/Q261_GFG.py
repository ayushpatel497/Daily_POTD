class Solution:
    def nextGreater(self, arr):
        n = len(arr)
        result = [-1] * n
        stack = []

        for i in range(2 * n):
            num = arr[i % n]
            while stack and arr[stack[-1]] < num:
                result[stack.pop()] = num
            if i < n:
                stack.append(i)
        
        return result
