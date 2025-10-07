from typing import List


class Solution:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        n = len(rains)
        ans = [1] * n
        dry_days = []
        full_lakes = {}
        
        import bisect
        
        for i, lake in enumerate(rains):
            if lake == 0:
                bisect.insort(dry_days, i)
            else:
                ans[i] = -1
                if lake in full_lakes:
                    idx = bisect.bisect_right(dry_days, full_lakes[lake])
                    if idx == len(dry_days):
                        return []
                    dry_day = dry_days[idx]
                    ans[dry_day] = lake
                    dry_days.pop(idx)
                full_lakes[lake] = i
        return ans
