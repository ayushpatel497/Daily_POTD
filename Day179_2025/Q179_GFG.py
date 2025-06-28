import bisect

class Solution:
    def countLessEq(self, a, b):
        b.sort()
        result = []
        for x in a:
            # bisect_right gives number of elements <= x
            idx = bisect.bisect_right(b, x)
            result.append(idx)
        return result
