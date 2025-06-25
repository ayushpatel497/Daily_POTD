from collections import Counter

class Solution:
    def sameFreq(self, s: str) -> bool:
        s = ''.join(sorted(s))
        freq_map = {}
        n = len(s)
        low = 0
        high = 0

        while low < n:
            while high < n and s[low] == s[high]:
                high += 1
            count = high - low
            freq_map[count] = freq_map.get(count, 0) + 1
            low = high

        if len(freq_map) > 2:
            return False
        if len(freq_map) == 1:
            return True

        (len1, freq1), (len2, freq2) = list(freq_map.items())

        if freq1 != 1 and freq2 != 1:
            return False
        if (len1 == 1 and freq1 == 1) or (len2 == 1 and freq2 == 1):
            return True
        if abs(len1 - len2) > 1:
            return False
        if (len1 > len2 and freq1 == 1) or (len2 > len1 and freq2 == 1):
            return True

        return False
