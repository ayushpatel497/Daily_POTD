class Solution:
    def solve(self, root, mini, maxi):
        if not root.left and not root.right:
            return mini == maxi

        if root.left and self.solve(root.left, mini, root.data - 1):
            return True

        if root.right and self.solve(root.right, root.data + 1, maxi):
            return True

        return False

    def isDeadEnd(self, root):
        return self.solve(root, 1, float('inf'))
