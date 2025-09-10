class Solution:
    def largestSwap(self, s: str) -> str:
        n = len(s)
        lar = n - 1
        
        for i in range(n - 1, -1, -1):
            if s[i] > s[lar]:
                lar = i
                
        s = list(s)
        for i in range(lar):
            if s[i] < s[lar]:
                s[i], s[lar] = s[lar], s[i]
                break
                
        return ''.join(s)
