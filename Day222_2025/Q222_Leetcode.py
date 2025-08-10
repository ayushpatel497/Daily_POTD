class Solution:
    def reorderedPowerOf2(self, n: int) -> bool:
        n1 = sorted(str(n))
        for i in range(30):
            n2 = sorted(str(1 << i))
            if n1 == n2:
                return True
        return False
