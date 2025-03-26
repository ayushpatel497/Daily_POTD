class Solution:
    def wordBreak(self, s: str, dictionary: list) -> bool:
        n = len(s)
        word_set = set(dictionary)  # Using a set for faster lookup
        dp = [False] * (n + 1)
        dp[0] = True

        for i in range(1, n + 1):
            for word in dictionary:
                start = i - len(word)
                if start >= 0 and dp[start] and s[start:i] == word:
                    dp[i] = True
                    break

        return dp[n]
