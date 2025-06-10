class Solution:
    def maxDifference(self, s: str) -> int:
        odd = -1
        even = float('inf')
        frq = [0] * 26

        for c in s:
            frq[ord(c) - ord('a')] += 1

        for f in frq:
            if f % 2 == 1:
                odd = max(odd, f)
            elif f != 0:
                even = min(even, f)

        return odd - even
