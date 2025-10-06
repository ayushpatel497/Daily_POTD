class Solution:
    def knightTour(self, n):
        self.ans = []
        self.flag = False
        arr = [-1, 1, -2, -2, -1, 1, 2, 2]
        brr = [-2, -2, -1, 1, 2, 2, -1, 1]
        
        vis = [[-1 for _ in range(n)] for _ in range(n)]
        vis[0][0] = 0
        
        def solve(i, j, step):
            if self.flag:
                return
            
            if step == n * n:
                self.ans = [row[:] for row in vis]
                self.flag = True
                return
            
            for x in range(8):
                p, q = i + arr[x], j + brr[x]
                if 0 <= p < n and 0 <= q < n and vis[p][q] == -1:
                    vis[p][q] = step
                    solve(p, q, step + 1)
                    vis[p][q] = -1
        
        solve(0, 0, 1)
        return self.ans
