class Solution:
    def countPS(self, s):
        n = len(s)
        ans = 0

        for mid in range(n):
            count = 1
            # Odd length palindromes
            for i in range(1, n - mid):
                if mid - i >= 0 and s[mid - i] == s[mid + i]:
                    count += 1
                else:
                    break
            ans += count
            count = 0

            # Even length palindromes
            for i in range(n - mid - 1):
                if mid - i >= 0 and s[mid - i] == s[mid + i + 1]:
                    count += 1
                else:
                    break
            ans += count

        return ans - n
