class Solution:
    def rowWithMax1s(self, arr):
        n = len(arr)
        m = len(arr[0])

        max_row = -1
        max_ones = -1

        for i in range(n):
            count = 0
            for j in range(m):
                if arr[i][j] == 1:
                    count = m - j
                    break

            if count > max_ones:
                max_ones = count
                max_row = i

        return max_row
