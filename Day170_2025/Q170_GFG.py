class Solution:
    def caseSort(self, s):
        lower = [0] * 26
        upper = [0] * 26

        for ch in s:
            if ch.islower():
                lower[ord(ch) - ord('a')] += 1
            else:
                upper[ord(ch) - ord('A')] += 1

        result = []
        l = u = 0

        for ch in s:
            if ch.islower():
                while lower[l] == 0:
                    l += 1
                result.append(chr(ord('a') + l))
                lower[l] -= 1
            else:
                while upper[u] == 0:
                    u += 1
                result.append(chr(ord('A') + u))
                upper[u] -= 1

        return ''.join(result)
