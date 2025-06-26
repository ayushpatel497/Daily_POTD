class Solution:
    def longestSubsequence(self, s: str, k: int) -> int:
        sm = 0
        cnt = 0
        bits = k.bit_length()

        n = len(s)
        for i in range(n):
            ch = s[n - 1 - i]
            if ch == '1':
                if i < bits and sm + (1 << i) <= k:
                    sm += 1 << i
                    cnt += 1
            else:
                cnt += 1

        return cnt
