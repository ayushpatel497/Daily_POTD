class Solution:
    def countPS(self, s: str) -> int:
        n = len(s)
        count = 0

        for center in range(n):
            # Odd length palindromes
            count += self.countPalindromes(s, center, center)
            # Even length palindromes
            count += self.countPalindromes(s, center, center + 1)

        return count

    def countPalindromes(self, s, left, right):
        count = 0
        while left >= 0 and right < len(s) and s[left] == s[right]:
            count += 1
            left -= 1
            right += 1
        return count
