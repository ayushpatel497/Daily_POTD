class Solution:
    def __init__(self):
        self.i = 0  # Pointer to track position in the string

    def decodedString(self, s: str) -> str:
        ans = ""
        curr = 0

        while self.i < len(s):
            if s[self.i].isdigit():
                curr = curr * 10 + int(s[self.i])  # Build the number
            elif s[self.i] == "[":
                self.i += 1  # Move past '['
                nested = self.decodedString(s)  # Recursively decode
                ans += nested * curr  # Repeat the nested string
                curr = 0  # Reset the number
            elif s[self.i] == "]":
                return ans  # Return when we reach a closing bracket
            else:
                ans += s[self.i]  # Append normal characters
            
            self.i += 1  # Move to the next character
        
        return ans
