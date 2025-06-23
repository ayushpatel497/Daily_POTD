class Solution:
    def kMirror(self, k: int, n: int) -> int:
        def is_k_palindrome(x: int) -> bool:
            digits = []
            while x > 0:
                digits.append(x % k)
                x //= k
            return digits == digits[::-1]

        count = 0
        total = 0
        left = 1

        while count < n:
            right = left * 10
            for op in range(2):
                for i in range(left, right):
                    if count >= n:
                        break
                    val = i
                    x = i // 10 if op == 0 else i
                    while x > 0:
                        val = val * 10 + x % 10
                        x //= 10
                    if is_k_palindrome(val):
                        total += val
                        count += 1
            left = right
        return total
