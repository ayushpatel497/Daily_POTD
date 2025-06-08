from typing import List


class Solution:
    def lexicalOrder(self, n: int) -> List[int]:
        ans = []
        x = 1
        for _ in range(n):
            ans.append(x)
            if x * 10 <= n:
                x *= 10
            else:
                if x >= n:
                    x //= 10
                x += 1
                while x % 10 == 0:
                    x //= 10
        return ans
