class Solution:
    def kthSmallest(self, mat, k):
        arr = []
        for row in mat:
            for val in row:
                arr.append(val)

        arr.sort()
        return arr[k - 1]
