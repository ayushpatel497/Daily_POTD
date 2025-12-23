from bisect import bisect_left, bisect_right

class Solution:
    def cntInRange(self, arr, queries):
        arr.sort()
        ans = []

        for a, b in queries:
            left = bisect_left(arr, a)
            right = bisect_right(arr, b)
            ans.append(right - left)

        return ans
