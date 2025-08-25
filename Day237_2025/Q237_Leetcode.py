from typing import List
from collections import defaultdict

class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        diag_map = defaultdict(list)
        m, n = len(mat), len(mat[0])
        
        for i in range(m):
            for j in range(n):
                diag_map[i + j].append(mat[i][j])
        
        res = []
        for k in range(m + n - 1):
            diag = diag_map[k]
            if k % 2 == 0:
                diag.reverse()
            res.extend(diag)
        
        return res
