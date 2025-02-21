class Solution:
    def isBalanced(self, s: str) -> bool:
        # Use list as a stack
        stack = []
        
        for ch in s:
            if ch in "({[":
                stack.append(ch)
            else:
                if stack and ((stack[-1] == '(' and ch == ')') or
                              (stack[-1] == '{' and ch == '}') or
                              (stack[-1] == '[' and ch == ']')):
                    stack.pop()
                else:
                    return False
        return not stack

# Example usage
if __name__ == "__main__":
    tests = ["{[()]}", "{[(])}", "((()))", "([{}])", "((({}))"]
    sol = Solution()
    for test in tests:
        print(f"{test} -> {sol.isBalanced(test)}")
