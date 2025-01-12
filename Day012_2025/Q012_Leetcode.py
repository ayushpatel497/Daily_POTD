class Solution:
    def canBeValid(self, s: str, locked: str) -> bool:
        # Q. Check if a Parentheses String Can Be Valid
        n = len(s)
        if n % 2 != 0:
            return False

        min_open, max_open = 0, 0

        for i in range(n):
            if locked[i] == '0':
                max_open += 1
                min_open = max(min_open - 1, 0)
            else:
                if s[i] == '(':
                    min_open += 1
                    max_open += 1
                else:
                    max_open -= 1
                    min_open = max(min_open - 1, 0)
            
            if max_open < 0:
                return False

        return min_open == 0


# Example usage
if __name__ == "__main__":
    sol = Solution()
    print(sol.canBeValid("))()(", "01010"))  # Example test
