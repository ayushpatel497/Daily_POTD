class Solution:
    def f(self, st, e, arr):
        for i in range(st, e + 1):
            if arr[i] > e - st + 1:
                return max(self.f(st, i - 1, arr), self.f(i + 1, e, arr))
        return e - st + 1

    def longestSubarray(self, arr):
        n = len(arr)
        return self.f(0, n - 1, arr)
