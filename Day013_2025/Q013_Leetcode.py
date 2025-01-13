class Solution:
    def minimumLength(self, s: str) -> int:
        # Q. Minimum Length of String After Operations
        freq = [0] * 26
        for c in s:
            freq[ord(c) - ord('a')] += 1
        ans = 0
        for f in freq:
            if f > 0:
                if f & 1:
                    ans += 1
                else:
                    ans += 2
        return ans

if __name__ == "__main__":
    sol = Solution()
    s = input("Enter string: ")
    print("Minimum Length:", sol.minimumLength(s))