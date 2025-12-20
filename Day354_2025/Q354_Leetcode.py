from typing import List

class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        delete_count = 0
        rows = len(strs)
        cols = len(strs[0])

        for j in range(cols):
            for i in range(rows - 1):
                if strs[i][j] > strs[i + 1][j]:
                    delete_count += 1
                    break

        return delete_count
