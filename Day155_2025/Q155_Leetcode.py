class Solution:
    def lastSubstring(self, s: str) -> str:
        i, j, n = 0, 1, len(s)
        while j < n:
            k = 0
            while j + k < n and s[i + k] == s[j + k]:
                k += 1
            if j + k < n and s[i + k] < s[j + k]:
                t = i
                i = j
                j = max(j + 1, t + k + 1)
            else:
                j = j + k + 1
        return s[i:]

    def answerString(self, word: str, numFriends: int) -> str:
        if numFriends == 1:
            return word
        last = self.lastSubstring(word)
        n = len(word)
        m = len(last)
        return last[:min(m, n - numFriends + 1)]
