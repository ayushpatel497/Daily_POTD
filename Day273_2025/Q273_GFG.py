class Solution:
    def binstr(self, n):
        res = []

        def solve(n, curr):
            if n == 0:
                res.append(curr)
                return
            solve(n - 1, curr + "0")
            solve(n - 1, curr + "1")

        solve(n, "")
        return res
