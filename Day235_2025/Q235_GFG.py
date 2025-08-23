class Solution:
    def isPossible(self, arr, k, pageLimit):
        count, pageSum = 1, 0
        for num in arr:
            if pageSum + num > pageLimit:
                count += 1
                pageSum = num
            else:
                pageSum += num
        return count <= k

    def findPages(self, arr, k):
        if k > len(arr):
            return -1

        start, end = max(arr), sum(arr)
        ans = -1

        while start <= end:
            mid = start + (end - start) // 2
            if self.isPossible(arr, k, mid):
                ans = mid
                end = mid - 1
            else:
                start = mid + 1
        return ans
