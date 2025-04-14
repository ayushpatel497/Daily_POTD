from typing import List
class Solution:
    def countGoodTriplets(self, arr: List[int], a: int, b: int, c: int) -> int:
        ans = 0
        n = len(arr)
        sum_prefix = [0] * 1001

        for j in range(n):
            for k in range(j + 1, n):
                if abs(arr[j] - arr[k]) <= b:
                    lj, rj = arr[j] - a, arr[j] + a
                    lk, rk = arr[k] - c, arr[k] + c
                    l = max(0, max(lj, lk))
                    r = min(1000, min(rj, rk))
                    if l <= r:
                        if l == 0:
                            ans += sum_prefix[r]
                        else:
                            ans += sum_prefix[r] - sum_prefix[l - 1]

            for k in range(arr[j], 1001):
                sum_prefix[k] += 1

        return ans
