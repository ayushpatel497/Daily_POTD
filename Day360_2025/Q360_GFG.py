class Solution:
    def kthMissing(self, arr, k):
        n = len(arr)
        ans = n
        start, end = 0, n - 1

        while start <= end:
            mid = start + (end - start) // 2

            # missing numbers till index mid
            if arr[mid] - mid - 1 >= k:
                ans = mid
                end = mid - 1
            else:
                start = mid + 1

        return ans + k
