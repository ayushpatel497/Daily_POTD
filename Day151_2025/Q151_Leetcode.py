from typing import List


class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        from collections import deque
        
        n = len(board)
        cells = [None] * (n * n + 1)
        label = 1
        columns = list(range(n))
        
        for row in range(n - 1, -1, -1):
            for col in columns:
                cells[label] = (row, col)
                label += 1
            columns.reverse()
        
        dist = [-1] * (n * n + 1)
        dist[1] = 0
        q = deque([1])

        while q:
            curr = q.popleft()
            for next_cell in range(curr + 1, min(curr + 6, n * n) + 1):
                row, col = cells[next_cell]
                dest = board[row][col] if board[row][col] != -1 else next_cell
                if dist[dest] == -1:
                    dist[dest] = dist[curr] + 1
                    q.append(dest)

        return dist[n * n]
