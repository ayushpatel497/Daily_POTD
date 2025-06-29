class Solution:
    def isFeasible(self, arr, k, maxSum):
        count = 1
        total = 0
        for num in arr:
            total += num
            if total > maxSum:
                total = num
                count += 1
                if count > k:
                    return False
        return True

    def splitArray(self, arr, k):
        left, right = max(arr), sum(arr)
        while left < right:
            mid = (left + right) // 2
            if self.isFeasible(arr, k, mid):
                right = mid
            else:
                left = mid + 1
        return left
