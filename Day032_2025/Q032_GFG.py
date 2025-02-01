from typing import List

class Solution:
    def __init__(self):
        self.directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

    def checkMoreCharacters(self, mat: List[List[str]], word: str, row: int, col: int, rowSize: int, colSize: int, visited: List[List[bool]], index: int) -> bool:
        if index == len(word):
            return True
        if row < 0 or col < 0 or row >= rowSize or col >= colSize or visited[row][col] or mat[row][col] != word[index]:
            return False
        
        visited[row][col] = True
        for dr, dc in self.directions:
            if self.checkMoreCharacters(mat, word, row + dr, col + dc, rowSize, colSize, visited, index + 1):
                return True
        visited[row][col] = False
        return False

    def isWordExist(self, mat: List[List[str]], word: str) -> bool:
        rowSize, colSize = len(mat), len(mat[0])
        visited = [[False] * colSize for _ in range(rowSize)]

        for row in range(rowSize):
            for col in range(colSize):
                if self.checkMoreCharacters(mat, word, row, col, rowSize, colSize, visited, 0):
                    return True
        return False
