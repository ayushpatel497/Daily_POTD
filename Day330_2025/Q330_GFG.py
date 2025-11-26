class Solution:
    def andInRange(self, l, r):
        ans = l
        diff = r - l
        bit = 1

        while bit <= diff:
            if ans & bit:
                ans = ans & (~bit)
            bit <<= 1

        return ans & r
