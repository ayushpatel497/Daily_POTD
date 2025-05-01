class Solution:

    def nthRowOfPascalTriangle(self, n):
        res = []
        prev = 1
        res.append(prev)

        for i in range(1, n):
            curr = (prev * (n - i)) // i
            res.append(curr)
            prev = curr

        return res
