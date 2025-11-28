class Solution:
    def subsetXOR(self, n: int):
        ans = []

        if n % 4 == 0:
            ans = [i for i in range(1, n + 1)]
        elif n % 4 == 1:
            ans = [i for i in range(1, n - 1)]
            ans.append(n)
        elif n % 4 == 2:
            ans = [i for i in range(2, n + 1)]
        else:  # n % 4 == 3
            ans = [i for i in range(1, n)]

        return ans
