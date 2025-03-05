class Solution:
    def longestStringChain(self, words):
        words.sort(key=len)
        dp = {}
        max_length = 1

        for word in words:
            length = 1
            for i in range(len(word)):
                sub = word[:i] + word[i+1:]
                length = max(length, dp.get(sub, 0) + 1)
            dp[word] = length
            max_length = max(max_length, length)
        
        return max_length
