class Solution:
    def hIndex(self, citations):
        n = len(citations)
        freq = [0] * (n + 1)
        
        for c in citations:
            if c >= n:
                freq[n] += 1
            else:
                freq[c] += 1
        
        idx = n
        s = freq[n]
        while s < idx:
            idx -= 1
            s += freq[idx]
        return idx
