class Solution:
    def asciirange(self, s):
        n = len(s)
        prefix = [0] * n
        prefix[0] = ord(s[0])
        for i in range(1, n):
            prefix[i] = prefix[i - 1] + ord(s[i])

        mp = {}
        for i in range(n):
            ch = s[i]
            if ch not in mp:
                mp[ch] = [i, i]
            else:
                mp[ch][1] = i

        res = []
        for ch in range(ord('a'), ord('z') + 1):
            c = chr(ch)
            if c in mp:
                l, r = mp[c]
                if r - l > 1:
                    total = prefix[r - 1] - prefix[l]
                    res.append(total)
        return res
