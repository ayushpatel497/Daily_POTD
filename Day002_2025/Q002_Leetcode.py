from typing import List

class Solution:
    def isVowel(self, c: str) -> bool:
        return c in 'aeiou'

    def check(self, s: str) -> bool:
        return self.isVowel(s[0]) and self.isVowel(s[-1])

    def vowelStrings(self, words: List[str], queries: List[List[int]]) -> List[int]:
        # Q. Count Vowel Strings in Ranges
        n = len(words)
        preSum = [0] * (n + 1)
        ans = []

        for i in range(n):
            preSum[i + 1] = preSum[i] + (1 if self.check(words[i]) else 0)

        for low, up in queries:
            ans.append(preSum[up + 1] - preSum[low])

        return ans

# Driver code
if __name__ == "__main__":
    sol = Solution()

    # Example input
    words = ["apple", "orange", "idea", "umbrella", "eagle"]
    queries = [[0, 2], [1, 4], [0, 4]]

    # Output results
    result = sol.vowelStrings(words, queries)
    print("Results:", result)
