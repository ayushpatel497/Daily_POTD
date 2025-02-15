class Solution:
    def LCA(self, root, n1, n2):
        if not root:
            return None

        # If both n1 and n2 are greater than root, LCA is in the right subtree
        if root.data < n1 and root.data < n2:
            return self.LCA(root.right, n1, n2)
        
        # If both n1 and n2 are smaller than root, LCA is in the left subtree
        elif root.data > n1 and root.data > n2:
            return self.LCA(root.left, n1, n2)
        
        # If one node is on the left and the other is on the right (or one is the root), return root
        return root
