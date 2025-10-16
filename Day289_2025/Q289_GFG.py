class Solution:
    def removekeys(self, root, l, r):
        if not root:
            return None
        
        # If current node is smaller than L, skip to right subtree
        if root.data < l:
            return self.removekeys(root.right, l, r)
        
        # If current node is greater than R, skip to left subtree
        if root.data > r:
            return self.removekeys(root.left, l, r)
        
        # Otherwise, fix both subtrees
        root.left = self.removekeys(root.left, l, r)
        root.right = self.removekeys(root.right, l, r)
        
        return root
