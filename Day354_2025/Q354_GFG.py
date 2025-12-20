class Solution:
    def searchInsertK(self, arr, k):
        start, end = 0, len(arr) - 1

        while start <= end:
            mid = start + (end - start) // 2

            if arr[mid] < k:
                start = mid + 1
            else:
                end = mid - 1

        return start
