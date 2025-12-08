class Solution:
    def matrixChainOrder(self, arr):
        n = len(arr)
        
        dp = [[None] * (n + 1) for _ in range(n + 1)]
        
        s = ''.join(chr(ord('A') + i) for i in range(n - 1))

        def solve(st, en):
            if st == en:
                return (0, s[st - 1])  # cost, string
            
            if dp[st][en] is not None:
                return dp[st][en]

            best_cost = float('inf')
            best_str = ""

            for k in range(st, en):
                left_cost, left_str = solve(st, k)
                right_cost, right_str = solve(k + 1, en)

                cost = arr[st - 1] * arr[k] * arr[en]
                total = left_cost + right_cost + cost

                if total < best_cost:
                    best_cost = total
                    best_str = "(" + left_str + right_str + ")"

            dp[st][en] = (best_cost, best_str)
            return dp[st][en]
        
        return solve(1, n - 1)[1]
