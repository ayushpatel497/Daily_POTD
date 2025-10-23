class Solution:
    def hasSameDigits(self, s: str) -> bool:
        n = len(s)
        s = list(s)
        
        for i in range(1, n - 1):
            for j in range(n - 1 - i + 1):
                s[j] = str((int(s[j]) + int(s[j + 1])) % 10)
        
        return s[0] == s[1]
