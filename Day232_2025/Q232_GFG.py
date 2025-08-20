class Solution:
    def searchMatrix(self, mat, x):
        n, m = len(mat), len(mat[0])
        size = n * m
        s, e = 0, size - 1

        while s <= e:
            mid = s + (e - s) // 2
            ele = mat[mid // m][mid % m]
            start = mat[s // m][s % m]
            end = mat[e // m][e % m]

            if ele == x:
                return True
            elif ele > end:
                if start <= x < ele:
                    e = mid - 1
                else:
                    s = mid + 1
            else:
                if ele < x <= end:
                    s = mid + 1
                else:
                    e = mid - 1
        return False
