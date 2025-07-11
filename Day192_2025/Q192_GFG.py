class Solution:
    def countConsec(self, n: int) -> int:
        if n == 1:
            return 0

        total = 1 << n  # Total binary strings of length n
        dp0, dp1 = 1, 1  # Ending in 0 and 1

        for _ in range(2, n + 1):
            new_dp0 = dp0 + dp1
            new_dp1 = dp0
            dp0, dp1 = new_dp0, new_dp1

        without_consecutive = dp0 + dp1
        return total - without_consecutive
