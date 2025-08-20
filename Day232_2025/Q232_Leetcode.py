from typing import List


class Solution:
    def countSquares(self, matrix: List[List[int]]) -> int:
        n, m = len(matrix), len(matrix[0])
        result = 0

        for i in range(n):
            for j in range(m):
                if i > 0 and j > 0 and matrix[i][j] > 0:
                    matrix[i][j] = min(matrix[i-1][j-1],
                                       matrix[i-1][j],
                                       matrix[i][j-1]) + 1
                result += matrix[i][j]
        return result
