class Solution:
    def smallestWindow(self, s, p):
        freqs = [0] * 26
        freqp = [0] * 26
        unique = 0
        
        for ch in p:
            if freqp[ord(ch) - ord('a')] == 0:
                unique += 1
            freqp[ord(ch) - ord('a')] += 1
        
        start = 0
        end = 0
        minLen = float("inf")
        match = 0
        ans = ""
        
        while end < len(s):
            freqs[ord(s[end]) - ord('a')] += 1
            
            if (freqs[ord(s[end]) - ord('a')] == freqp[ord(s[end]) - ord('a')] 
                and freqp[ord(s[end]) - ord('a')] > 0):
                match += 1
            
            if match >= unique:
                while start <= end and freqs[ord(s[start]) - ord('a')] > freqp[ord(s[start]) - ord('a')]:
                    freqs[ord(s[start]) - ord('a')] -= 1
                    start += 1
                
                length = end - start + 1
                if length < minLen:
                    minLen = length
                    ans = s[start:end+1]
            
            end += 1
        
        return ans
