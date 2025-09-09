class Solution:
    def assignHole(self, mices, holes):
        mices.sort()
        holes.sort()
        res = 0

        for i in range(len(mices)):
            res = max(res, abs(holes[i] - mices[i]))

        return res
