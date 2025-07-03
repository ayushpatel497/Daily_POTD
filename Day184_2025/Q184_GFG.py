class Solution:
    def longestKSubstr(self, s, k):
        freq = [0] * 26
        cnt = 0
        st = 0
        ans = -1

        for i in range(len(s)):
            if freq[ord(s[i]) - ord('a')] == 0:
                cnt += 1
            freq[ord(s[i]) - ord('a')] += 1

            if cnt > k:
                ans = max(ans, i - st)
                while st < i:
                    freq[ord(s[st]) - ord('a')] -= 1
                    if freq[ord(s[st]) - ord('a')] == 0:
                        cnt -= 1
                        st += 1
                        break
                    st += 1

        if cnt >= k:
            ans = max(ans, len(s) - st)

        return ans
