class Solution:
    def canReachHeight(self, arr, k, w, target):
        n = len(arr)
        water = [0] * (n + 1)
        ops = 0
        curr = 0

        for i in range(n):
            curr += water[i]
            effective_height = arr[i] + curr

            if effective_height < target:
                add = target - effective_height
                ops += add
                if ops > k:
                    return False

                curr += add
                if i + w < n:
                    water[i + w] -= add

        return True

    def maxMinHeight(self, arr, k, w):
        low = min(arr)
        high = low + k
        answer = low

        while low <= high:
            mid = (low + high) // 2
            if self.canReachHeight(arr, k, w, mid):
                answer = mid
                low = mid + 1
            else:
                high = mid - 1

        return answer
