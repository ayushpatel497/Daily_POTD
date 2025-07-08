class Solution:
    def findGreater(self, arr):
        from collections import Counter

        n = len(arr)
        freq = Counter(arr)
        res = [-1] * n
        stack = []

        for i in range(n):
            while stack and freq[arr[i]] > freq[arr[stack[-1]]]:
                res[stack.pop()] = arr[i]
            stack.append(i)

        return res
