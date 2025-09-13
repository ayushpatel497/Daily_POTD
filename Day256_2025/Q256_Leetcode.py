class Solution:
    def is_vowel(self, c: str) -> bool:
        return c in 'aeiou'

    def maxFreqSum(self, s: str) -> int:
        from collections import Counter
        mp = Counter(s)
        
        vowel = 0
        consonant = 0
        
        for ch in 'abcdefghijklmnopqrstuvwxyz':
            freq = mp.get(ch, 0)
            if self.is_vowel(ch):
                vowel = max(vowel, freq)
            else:
                consonant = max(consonant, freq)
        
        return vowel + consonant
