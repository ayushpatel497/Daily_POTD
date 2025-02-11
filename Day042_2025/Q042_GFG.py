class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None

class Solution:
    def isValid(self, root, min_val, max_val):
        if root is None:
            return True
        if root.data <= min_val or root.data >= max_val:
            return False
        return self.isValid(root.left, min_val, root.data) and self.isValid(root.right, root.data, max_val)

    # Function to check whether a Binary Tree is BST or not.
    def isBST(self, root):
        return self.isValid(root, float('-inf'), float('inf'))
