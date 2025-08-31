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
                if board[row][col] == ".":
                    for val in map(str, range(1, 10)):
                        if self.isSafe(board, row, col, val):
                            board[row][col] = val
                            if self.solve(board):
                                return True
                            else:
                                board[row][col] = "."
                    return False
        return True

    def solveSudoku(self, board):
        """
        Do not return anything, modify board in-place instead.
        """
        self.solve(board)
