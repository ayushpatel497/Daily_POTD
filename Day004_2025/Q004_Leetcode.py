class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:
        # Q. Unique Length-3 Palindromic Subsequences
        firstt = [float('inf')] * 26
        lastt = [0] * 26

        for i, char in enumerate(s):
            idx = ord(char) - ord('a')
            firstt[idx] = min(firstt[idx], i)
            lastt[idx] = i

        ans = 0

        for i in range(26):
            if firstt[i] < lastt[i]:
                unique_chars = set(s[firstt[i] + 1 : lastt[i]])
                ans += len(unique_chars)

        return ans


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        s = input()
        sol = Solution()
        print(sol.countPalindromicSubsequence(s))
        print("~")
