class Solution:
    def canConstruct(self, s: str, k: int) -> bool:
        # Q. Construct K Palindrome Strings
        # If the length of the string is less than k, it's not possible
        if len(s) < k:
            return False

        # Frequency dictionary to count character occurrences
        freq = [0] * 26
        for char in s:
            freq[ord(char) - ord('a')] += 1

        # Count the number of characters with odd frequency
        odds = sum(f % 2 for f in freq)

        # If the number of odd frequencies is less than or equal to k, it's possible
        return odds <= k


# Example usage
if __name__ == "__main__":
    t = int(input())  # Number of test cases
    for _ in range(t):
        s = input()
        k = int(input())
        sol = Solution()
        print(sol.canConstruct(s, k))
