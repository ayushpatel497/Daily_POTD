class Solution(object):
    def kthSmallest(self, m, n, k):
        low, high = 1, m * n
        ans = high

        while low <= high:
            mid = (low + high) // 2
            count = 0

            for i in range(1, m + 1):
                count += min(mid // i, n)

            if count >= k:
                ans = mid
                high = mid - 1
            else:
                low = mid + 1

        return ans
