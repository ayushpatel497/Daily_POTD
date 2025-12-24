class Solution:
    def pivot(self, arr):
        l, h = 0, len(arr) - 1
        while l < h:
            m = l + (h - l) // 2
            if arr[m] > arr[h]:
                l = m + 1
            else:
                h = m
        return l

    def upper_bound(self, arr, l, r, x):
        while l < r:
            m = l + (r - l) // 2
            if arr[m] <= x:
                l = m + 1
            else:
                r = m
        return l

    def countLessEqual(self, arr, x):
        piv = self.pivot(arr)

        c1 = self.upper_bound(arr, 0, piv, x)
        c2 = self.upper_bound(arr, piv, len(arr), x) - piv

        return c1 + c2
