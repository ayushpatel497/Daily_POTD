class Solution:
    def getLongestPrefix(self, s):
        n = len(s)
        i = 0
        j = n - 1
        pos = n - 1
        ans = 0
        
        while j < n and pos > 0:
            if s[i] == s[j]:
                i += 1
                j += 1
                ans += 1
            else:
                i = 0
                pos -= 1
                j = pos
                ans = 0
        
        if pos == 0:
            return -1
        return n - ans