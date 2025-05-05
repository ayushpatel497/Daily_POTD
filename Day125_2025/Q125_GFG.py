class Solution:
    def findTarget(self, arr, target):
        n = len(arr)
        low, high = 0, n - 1

        while low <= high:
            mid = (low + high) // 2

            if arr[mid] == target:
                return mid
            if mid - 1 >= low and arr[mid - 1] == target:
                return mid - 1
            if mid + 1 <= high and arr[mid + 1] == target:
                return mid + 1

            if arr[mid] < target:
                low = mid + 2
            else:
                high = mid - 2

        return -1
