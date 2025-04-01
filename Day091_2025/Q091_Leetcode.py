from typing import List

class Solution:
    def mostPoints(self, questions: List[List[int]]) -> int:
        n = len(questions)
        dp = [0] * (n + 1)

        for i in range(n - 1, -1, -1):
            point, jump = questions[i]
            nextQuestion = min(n, i + jump + 1)
            dp[i] = max(dp[i + 1], point + dp[nextQuestion])
        
        return dp[0]

# Example Usage
sol = Solution()
questions = [[3, 2], [4, 3], [4, 4], [2, 5]]
print(sol.mostPoints(questions))  # Output: Maximum points that can be obtained
