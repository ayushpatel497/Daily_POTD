from typing import List


class Solution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        answer = 0
        n = len(colors)
        
        for i in range(1, n):
            if colors[i] == colors[i - 1]:
                answer += min(neededTime[i], neededTime[i - 1])
                neededTime[i] = max(neededTime[i], neededTime[i - 1])
                
        return answer
