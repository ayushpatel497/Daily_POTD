from typing import List

class Solution:
    def calculateSpan(self, arr: List[int]) -> List[int]:
        n = len(arr)
        answer = [1] * n
        stack = []
        
        for i in range(n):
            while stack and arr[stack[-1]] <= arr[i]:
                answer[i] += answer[stack[-1]]
                stack.pop()
            stack.append(i)
        
        return answer
