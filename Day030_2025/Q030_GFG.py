class Solution:
    def __init__(self):
        self.result = []
        self.row = []

    def isSafe(self, r, c):
        for prev in range(c):
            if self.row[prev] == r or abs(self.row[prev] - r) == abs(prev - c):
                return False
        return True

    def solveNQueens(self, column, n):
        if n == 2 or n == 3:
            return
        
        if column == n:
            self.result.append([self.row[i] + 1 for i in range(n)])
            return
        
        for i in range(n):
            if self.isSafe(i, column):
                self.row[column] = i
                self.solveNQueens(column + 1, n)

    def nQueen(self, n):
        self.result = []
        self.row = [-1] * n
        self.solveNQueens(0, n)
        return self.result
