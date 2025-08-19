class Solution:
    def farMin(self, arr):
        n = len(arr)
        suffix = [float('inf')] * (n + 1)

        # build suffix min
        for i in range(n - 1, -1, -1):
            suffix[i] = min(suffix[i + 1], arr[i])

        result = [-1] * n

        # binary search for each element
        for i in range(n - 1):
            s, e = i + 1, n - 1
            while s <= e:
                mid = s + (e - s) // 2
                if suffix[mid] < arr[i]:
                    result[i] = mid
                    s = mid + 1
                else:
                    e = mid - 1

        return result
