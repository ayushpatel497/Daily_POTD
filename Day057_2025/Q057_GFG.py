from typing import List

class Solution:
    def maxOfMins(self, arr: List[int]) -> List[int]:
        n = len(arr)
        res = [0] * n
        stack = []
        length = [0] * n
        
        for i in range(n):
            while stack and arr[stack[-1]] >= arr[i]:
                top = stack.pop()
                window_size = i if not stack else i - stack[-1] - 1
                length[top] = window_size
            stack.append(i)
        
        while stack:
            top = stack.pop()
            window_size = n if not stack else n - stack[-1] - 1
            length[top] = window_size
        
        for i in range(n):
            window_size = length[i] - 1
            res[window_size] = max(res[window_size], arr[i])
        
        for i in range(n - 2, -1, -1):
            res[i] = max(res[i], res[i + 1])
        
        return res

# Example usage
if __name__ == "__main__":
    t = int(input().strip())
    for _ in range(t):
        arr = list(map(int, input().split()))
        sol = Solution()
        print(" ".join(map(str, sol.maxOfMins(arr))))
        print("~")
