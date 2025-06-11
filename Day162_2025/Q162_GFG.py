class Solution:
    def findLength(self, color, radius):
        stack = []
        n = len(color)

        for i in range(n):
            if stack and stack[-1] == (color[i], radius[i]):
                stack.pop()  # remove matching pair
            else:
                stack.append((color[i], radius[i]))
        
        return len(stack)
