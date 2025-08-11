class Solution:
    def maxSum(self, s: str) -> int:
        n = len(s)
        if n < 2:
            return 0

        rad = [0] * n
        L, R = 0, -1
        for i in range(n):
            k = 1 if i > R else min(rad[L + R - i], R - i + 1)
            while i - k >= 0 and i + k < n and s[i - k] == s[i + k]:
                k += 1
            rad[i] = k
            if i + k - 1 > R:
                L = i - k + 1
                R = i + k - 1

        bestEnd = [0] * n
        bestStart = [0] * n
        for c in range(n):
            length = 2 * rad[c] - 1
            l = c - rad[c] + 1
            r = c + rad[c] - 1
            bestEnd[r] = max(bestEnd[r], length)
            bestStart[l] = max(bestStart[l], length)

        for i in range(n - 2, -1, -1):
            bestEnd[i] = max(bestEnd[i], bestEnd[i + 1] - 2)

        for i in range(1, n):
            bestStart[i] = max(bestStart[i], bestStart[i - 1] - 2)

        bestLeft, ans = 0, 0
        for i in range(n - 1):
            bestLeft = max(bestLeft, bestEnd[i])
            ans = max(ans, bestLeft + bestStart[i + 1])

        return ans


if __name__ == "__main__":
    sol = Solution()
    s = "abacaba"
    print(sol.maxSum(s))  # Example test
