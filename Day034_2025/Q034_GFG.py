class Solution:
    # Function to find the height of a binary tree.
    def height(self, root):
        if root is None:
            return 0  # Since height of an empty tree is 0
        return 1 + max(self.height(root.left), self.height(root.right))
