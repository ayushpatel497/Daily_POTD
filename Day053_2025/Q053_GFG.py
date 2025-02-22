class Solution:
    @staticmethod
    def maxLength(s: str) -> int:
        n = len(s)
        left = right = maxlength = 0
        
        # Left-to-right scan
        for ch in s:
            if ch == '(':
                left += 1
            else:
                right += 1
            if left == right:
                maxlength = max(maxlength, 2 * right)
            elif right > left:
                left = right = 0
        
        # Reset counters for right-to-left scan
        left = right = 0
        for ch in s[::-1]:
            if ch == '(':
                left += 1
            else:
                right += 1
            if left == right:
                maxlength = max(maxlength, 2 * left)
            elif left > right:
                left = right = 0
                
        return maxlength

# Example usage:
if __name__ == "__main__":
    s = "(()))("
    print("Longest valid parentheses length:", Solution.maxLength(s))
