class Solution:
    def clearStars(self, s: str) -> str:
        cnt = [ [] for _ in range(26) ]
        s = list(s)

        for i in range(len(s)):
            if s[i] != '*':
                cnt[ord(s[i]) - ord('a')].append(i)
            else:
                for j in range(26):
                    if cnt[j]:
                        s[cnt[j].pop()] = '*'
                        break

        return ''.join([c for c in s if c != '*'])
