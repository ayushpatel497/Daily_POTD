class Solution:
    def kthCharacter(self, k: int, operations: list[int]) -> str:
        k -= 1  # convert to 0-based index
        ans = 0
        for i in range(60, -1, -1):  # supports up to 2^60 bits
            if (k >> i) & 1:
                if i < len(operations):
                    ans += operations[i]
        return chr(ord('a') + (ans % 26))
