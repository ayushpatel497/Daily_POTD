class Solution:
    def longestSubarray(self, arr, k):
        n = len(arr)
        res = 0
        sum_ = 0
        index_map = {0: -1}

        for i in range(n):
            if arr[i] > k:
                sum_ += 1
            else:
                sum_ -= 1

            if sum_ not in index_map:
                index_map[sum_] = i

            if (sum_ - 1) in index_map:
                res = max(res, i - index_map[sum_ - 1])

            if sum_ > 0:
                res = max(res, i + 1)

        return res
