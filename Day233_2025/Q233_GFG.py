class Solution:
    def isPossible(self, arr, gap, k):
        count = 1
        prev = arr[0]
        for i in range(1, len(arr)):
            if arr[i] - prev >= gap:
                count += 1
                prev = arr[i]
            if count == k:
                return True
        return False

    def maxMinDiff(self, arr, k):
        arr.sort()
        low, high = 0, arr[-1] - arr[0]
        ans = 0

        while low <= high:
            mid = (low + high) // 2
            if self.isPossible(arr, mid, k):
                ans = mid
                low = mid + 1
            else:
                high = mid - 1
        return ans
