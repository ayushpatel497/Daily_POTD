class Solution:
    def cntSubarrays(self, arr, k):
        prefix_sums = {}
        res = 0
        curr_sum = 0

        for num in arr:
            curr_sum += num

            if curr_sum == k:
                res += 1

            if (curr_sum - k) in prefix_sums:
                res += prefix_sums[curr_sum - k]

            prefix_sums[curr_sum] = prefix_sums.get(curr_sum, 0) + 1

        return res
