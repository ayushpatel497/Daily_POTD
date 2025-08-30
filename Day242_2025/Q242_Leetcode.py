from typing import List


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row = [[False] * 9 for _ in range(9)]
        col = [[False] * 9 for _ in range(9)]
        grid = [[False] * 9 for _ in range(9)]
        
        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    continue
                num = int(board[i][j]) - 1
                k = 3 * (i // 3) + (j // 3)
                
                if row[i][num] or col[j][num] or grid[k][num]:
                    return False
                
                row[i][num] = col[j][num] = grid[k][num] = True
        return True
