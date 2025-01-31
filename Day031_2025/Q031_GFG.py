class Solution:
    def isSafe(self, board, row, col, val):
        for i in range(9):
            if board[row][i] == val:
                return False
            if board[i][col] == val:
                return False
            if board[3 * (row // 3) + i // 3][3 * (col // 3) + i % 3] == val:
                return False
        return True

    def solve(self, board):
        for row in range(9):
            for col in range(9):
                if board[row][col] == 0:
                    for val in range(1, 10):
                        if self.isSafe(board, row, col, val):
                            board[row][col] = val
                            if self.solve(board):
                                return True
                            board[row][col] = 0  # Backtrack
                    return False
        return True

    # Function to solve the Sudoku
    def solveSudoku(self, mat):
        self.solve(mat)
