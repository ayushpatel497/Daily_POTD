class Solution:
    def decodedString(self, s: str) -> str:
        stack = []
        
        for ch in s:
            if ch != ']':
                stack.append(ch)
            else:
                temp = []
                while stack and stack[-1] != '[':
                    temp.append(stack.pop())
                stack.pop()  # Remove '['
                temp.reverse()
                num = []
                while stack and stack[-1].isdigit():
                    num.append(stack.pop())
                num.reverse()
                number = int(''.join(num))
                
                expanded = temp * number
                stack.extend(expanded)
        
        return ''.join(stack)
