from typing import List


class Solution:
    def numSubmat(self, mat: List[List[int]]) -> int:
        n = len(mat[0])
        heights = [0] * n
        res = 0

        for row in mat:
            for i in range(n):
                heights[i] = 0 if row[i] == 0 else heights[i] + 1

            st = [[-1, 0, -1]]  # (index, prev_sum, height)

            for i in range(n):
                h = heights[i]
                while st[-1][2] >= h:
                    st.pop()
                j, prev, _ = st[-1]
                cur = prev + (i - j) * h
                st.append([i, cur, h])
                res += cur

        return res
