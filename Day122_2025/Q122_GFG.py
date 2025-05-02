class Solution:
    def findMaximum(self, arr):
        n = len(arr)

        if n == 1:
            return arr[0]
        if arr[0] > arr[1]:
            return arr[0]
        if arr[n - 1] > arr[n - 2]:
            return arr[n - 1]

        lo, hi = 0, n - 1
        while lo <= hi:
            mid = (lo + hi) // 2
            if 0 < mid < n - 1 and arr[mid] > arr[mid - 1] and arr[mid] > arr[mid + 1]:
                return arr[mid]
            elif mid < n - 1 and arr[mid] < arr[mid + 1]:
                lo = mid + 1
            else:
                hi = mid - 1
        return -1  # Ideally shouldn't happen
