class Solution:
    def countSubstring(self, s: str) -> int:
        from collections import Counter
        freq = Counter(s)
        total = 0

        for count in freq.values():
            total += count * (count + 1) // 2

        return total
