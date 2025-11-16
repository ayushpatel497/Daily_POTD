class Solution:
    def numSub(self, s: str) -> int:
        P = 10**9 + 7
        n = len(s)
        p = 0
        ans = 0

        while p < n:
            if s[p] == '0':
                p += 1
                continue

            cnt = 0
            while p < n and s[p] == '1':
                cnt += 1
                p += 1

            ans = (ans + (cnt + 1) * cnt // 2) % P

        return ans
