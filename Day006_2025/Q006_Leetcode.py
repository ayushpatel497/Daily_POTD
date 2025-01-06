from typing import List

class Solution:
    def minOperations(self, boxes: str) -> List[int]:
        # Q. Minimum Number of Operations to Move All Balls to Each Box
        n = len(boxes)
        ans = [0] * n

        ballsToLeft = 0
        movesToLeft = 0
        ballsToRight = 0
        movesToRight = 0

        # Calculate operations from left to right
        for i in range(n):
            ans[i] += movesToLeft
            ballsToLeft += int(boxes[i])
            movesToLeft += ballsToLeft

        # Calculate operations from right to left
        for i in range(n - 1, -1, -1):
            ans[i] += movesToRight
            ballsToRight += int(boxes[i])
            movesToRight += ballsToRight

        return ans


if __name__ == "__main__":
    sol = Solution()
    boxes = "110"
    result = sol.minOperations(boxes)
    print(result)
