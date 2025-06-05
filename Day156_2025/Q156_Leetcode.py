class Solution:
    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        ch = [chr(i + ord('a')) for i in range(26)]

        for a, b in zip(s1, s2):
            to_replace = max(ch[ord(a) - ord('a')], ch[ord(b) - ord('a')])
            replace_with = min(ch[ord(a) - ord('a')], ch[ord(b) - ord('a')])
            for i in range(26):
                if ch[i] == to_replace:
                    ch[i] = replace_with

        return ''.join(ch[ord(c) - ord('a')] for c in baseStr)
