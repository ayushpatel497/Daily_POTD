class Solution:
    def findSubString(self, s):
        unique_chars = set(s)
        required = len(unique_chars)
        freq = {}
        left = 0
        ans = len(s)

        for right in range(len(s)):
            freq[s[right]] = freq.get(s[right], 0) + 1

            while len(freq) == required:
                ans = min(ans, right - left + 1)
                freq[s[left]] -= 1
                if freq[s[left]] == 0:
                    del freq[s[left]]
                left += 1

        return ans
