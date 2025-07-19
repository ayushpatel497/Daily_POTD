class Solution:
    def vowelCount(self, s: str) -> int:
        from math import factorial

        vowels = set('aeiou')
        freq = {}

        for c in s:
            if c in vowels:
                freq[c] = freq.get(c, 0) + 1

        if not freq:
            return 0

        choices = 1
        for count in freq.values():
            choices *= count

        return choices * factorial(len(freq))
