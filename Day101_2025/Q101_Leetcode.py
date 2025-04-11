class Solution:
    def countSymmetricIntegers(self, low: int, high: int) -> int:
        res = 0

        for num in range(low, high + 1):
            s = str(num)
            if len(s) % 2 != 0:
                continue

            half = len(s) // 2
            left = sum(int(d) for d in s[:half])
            right = sum(int(d) for d in s[half:])

            if left == right:
                res += 1

        return res
