from typing import List

class Solution:
    def getMaxArea(self, arr: List[int]) -> int:
        n = len(arr)
        stack = []
        res = 0
        
        for i in range(n):
            while stack and arr[stack[-1]] >= arr[i]:
                tp = stack.pop()
                width = i if not stack else i - stack[-1] - 1
                res = max(res, arr[tp] * width)
            stack.append(i)
        
        while stack:
            tp = stack.pop()
            width = n if not stack else n - stack[-1] - 1
            res = max(res, arr[tp] * width)
            
        return res

# Example usage:
if __name__ == "__main__":
    t = int(input().strip())
    for _ in range(t):
        arr = list(map(int, input().split()))
        sol = Solution()
        print(sol.getMaxArea(arr))
        print("~")
