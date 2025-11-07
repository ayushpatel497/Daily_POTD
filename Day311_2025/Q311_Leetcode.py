from typing import List

class Solution:
    def maxPower(self, stations: List[int], r: int, k: int) -> int:
        n = len(stations)
        count = [0] * (n + 1)
        
        # Build prefix-difference array for station influence
        for i in range(n):
            left = max(0, i - r)
            right = min(n, i + r + 1)
            count[left] += stations[i]
            count[right] -= stations[i]

        def check(value: int) -> bool:
            diff = count[:]  # make a copy
            total = 0
            remaining = k

            for i in range(n):
                total += diff[i]
                if total < value:
                    add = value - total
                    if remaining < add:
                        return False
                    remaining -= add
                    end = min(n, i + 2 * r + 1)
                    diff[end] -= add
                    total += add
            return True

        low = min(stations)
        high = sum(stations) + k
        result = 0

        # Binary search for maximum minimum power
        while low <= high:
            mid = (low + high) // 2
            if check(mid):
                result = mid
                low = mid + 1
            else:
                high = mid - 1

        return result
