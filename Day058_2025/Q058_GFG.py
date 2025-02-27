class Solution:
    def __init__(self):
        self.st = []
        self.mini = float('inf')

    # Add an element to the top of Stack
    def push(self, x: int):
        val = x
        if not self.st:
            self.mini = val
            self.st.append(val)
        else:
            if val < self.mini:
                self.st.append(2 * val - self.mini)
                self.mini = val
            else:
                self.st.append(val)

    # Remove the top element from the Stack
    def pop(self):
        if not self.st:
            return
        element = self.st.pop()
        if element < self.mini:
            self.mini = 2 * self.mini - element

    # Returns top element of the Stack
    def peek(self) -> int:
        if not self.st:
            return -1
        element = self.st[-1]
        return self.mini if element < self.mini else element

    # Finds minimum element of Stack
    def getMin(self) -> int:
        return -1 if not self.st else self.mini
