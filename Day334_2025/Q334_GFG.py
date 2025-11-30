class Solution:
    def countSubs(self, s: str) -> int:
        n = len(s)
        dp = [0] * (n + 1)

        for i in range(1, n + 1):
            for j in range(i - 1, 0, -1):
                cnt = 0
                t = i

                while j >= 1 and s[t - 1] == s[j - 1]:
                    cnt += 1
                    t -= 1
                    j -= 1

                if cnt > 0:
                    j += 1
                
                dp[i] = max(dp[i], cnt)

        ans = 0
        for i in range(1, n + 1):
            ans += i - dp[i]

        return ans
