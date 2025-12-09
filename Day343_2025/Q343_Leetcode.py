from typing import List


class Solution:
    def specialTriplets(self, nums: List[int]) -> int:
        MOD = 10**9 + 7

        numCnt = {}
        numPartialCnt = {}

        # Count full frequency of each number
        for v in nums:
            numCnt[v] = numCnt.get(v, 0) + 1

        ans = 0

        for v in nums:
            target = v * 2

            lCnt = numPartialCnt.get(target, 0)

            # Mark v as partially counted (left side)
            numPartialCnt[v] = numPartialCnt.get(v, 0) + 1

            rCnt = numCnt.get(target, 0) - numPartialCnt.get(target, 0)

            ans = (ans + lCnt * rCnt) % MOD

        return ans
