class Solution:
    def isBalance(self, x: int) -> bool:
        count = [0] * 10
        while x > 0:
            count[x % 10] += 1
            x //= 10
        for d in range(10):
            if count[d] > 0 and count[d] != d:
                return False
        return True

    def nextBeautifulNumber(self, n: int) -> int:
        for i in range(n + 1, 1224445):
            if self.isBalance(i):
                return i
        return -1
