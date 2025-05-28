class Solution:    
    def ValidCorner(self, mat):
        rows = len(mat)
        cols = len(mat[0])
        seen = set()

        for i in range(rows):
            for col1 in range(cols - 1):
                if mat[i][col1] == 0:
                    continue
                for col2 in range(col1 + 1, cols):
                    if mat[i][col2] == 0:
                        continue
                    key = (col1, col2)
                    if key in seen:
                        return True
                    seen.add(key)

        return False
