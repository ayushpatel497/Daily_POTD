class Solution:
    def inOrder(self, root):
        inorder_list = []
        self.fillInorder(root, inorder_list)
        return inorder_list

    # Helper function to perform inorder traversal
    def fillInorder(self, root, inorder_list):
        if root is None:
            return
        
        self.fillInorder(root.left, inorder_list)  # Traverse left subtree
        inorder_list.append(root.data)            # Visit root
        self.fillInorder(root.right, inorder_list) # Traverse right subtree
