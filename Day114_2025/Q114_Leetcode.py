from typing import List


class Solution:
    def countCompleteSubarrays(self, nums: List[int]) -> int:
        from collections import defaultdict

        n = len(nums)
        res = 0
        distinct_count = len(set(nums))
        cnt = defaultdict(int)
        right = 0

        for left in range(n):
            if left > 0:
                cnt[nums[left - 1]] -= 1
                if cnt[nums[left - 1]] == 0:
                    del cnt[nums[left - 1]]

            while right < n and len(cnt) < distinct_count:
                cnt[nums[right]] += 1
                right += 1

            if len(cnt) == distinct_count:
                res += (n - right + 1)

        return res
