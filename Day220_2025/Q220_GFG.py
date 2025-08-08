class Solution:
    def getLPSLength(self, s: str) -> int:
        n = len(s)
        
        for temp in range(n - 1, 0, -1):
            flag = True
            for i in range(temp):
                if s[i] != s[n - temp + i]:
                    flag = False
                    break
            if flag:
                return temp
        return 0
