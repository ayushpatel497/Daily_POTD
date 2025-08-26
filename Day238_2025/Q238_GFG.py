class Solution:
    def isSubSeq(self, s1: str, s2: str) -> bool:
        n, m = len(s1), len(s2)
        p1, p2 = 0, 0
        
        while p1 < n and p2 < m:
            if s1[p1] == s2[p2]:
                p1 += 1
            p2 += 1
        
        return p1 == n
