class Solution:
    def search(self, pat, txt):
        q = 101  # A prime number
        d = 26   # Alphabet size
        M = len(pat)
        N = len(txt)
        p = 0    # hash value for pattern
        t = 0    # hash value for txt
        h = 1
        res = []

        # h = pow(d, M-1) % q
        for i in range(M - 1):
            h = (h * d) % q

        # Calculate hash value for pattern and first window
        for i in range(M):
            p = (d * p + ord(pat[i])) % q
            t = (d * t + ord(txt[i])) % q

        for i in range(N - M + 1):
            if p == t:
                if txt[i:i+M] == pat:
                    res.append(i + 1)  # 1-based indexing

            if i < N - M:
                t = (d * (t - ord(txt[i]) * h) + ord(txt[i + M])) % q
                if t < 0:
                    t += q

        return res
