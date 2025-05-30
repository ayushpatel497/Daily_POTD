class Solution:
    def __init__(self):
        self.ans = -1

    def findMaxFork(self, root, k):
        if not root:
            return self.ans

        if root.data <= k:
            self.ans = max(self.ans, root.data)
            self.findMaxFork(root.right, k)
        else:
            self.findMaxFork(root.left, k)

        return self.ans
