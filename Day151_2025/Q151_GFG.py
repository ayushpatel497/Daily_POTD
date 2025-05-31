class Solution:
    def kthSmallest(self, matrix, k):
        arr = []
        for row in matrix:
            arr.extend(row)
        arr.sort()
        return arr[k - 1]
