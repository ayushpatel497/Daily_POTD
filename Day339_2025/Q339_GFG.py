from typing import List


class Solution:
    def minCost(self, cost: List[List[int]]) -> int:
        n = len(cost)
        k = len(cost[0])

        if k == 1:
            if n == 1:
                return cost[0][0]
            return -1

        # mini = (value, index)
        mini_val, mini_idx = float('inf'), -1
        smini_val, smini_idx = float('inf'), -1

        # First row
        for i in range(k):
            if cost[0][i] < mini_val:
                smini_val, smini_idx = mini_val, mini_idx
                mini_val, mini_idx = cost[0][i], i
            elif cost[0][i] < smini_val:
                smini_val, smini_idx = cost[0][i], i

        # DP for remaining rows
        for i in range(1, n):
            cur_mini_val, cur_mini_idx = float('inf'), -1
            cur_smini_val, cur_smini_idx = float('inf'), -1

            for j in range(k):
                if j != mini_idx:
                    x = cost[i][j] + mini_val
                else:
                    x = cost[i][j] + smini_val

                if x < cur_mini_val:
                    cur_smini_val, cur_smini_idx = cur_mini_val, cur_mini_idx
                    cur_mini_val, cur_mini_idx = x, j
                elif x < cur_smini_val:
                    cur_smini_val, cur_smini_idx = x, j

            mini_val, mini_idx = cur_mini_val, cur_mini_idx
            smini_val, smini_idx = cur_smini_val, cur_smini_idx

        return mini_val
