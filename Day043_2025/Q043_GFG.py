class Solution:
    # Helper function for in-order traversal
    def inOrderTraversal(self, root, k, count, result):
        if not root or count[0] >= k:
            return
        
        # Traverse left subtree
        self.inOrderTraversal(root.left, k, count, result)
        
        # Process current node
        count[0] += 1
        if count[0] == k:
            result[0] = root.data
            return
        
        # Traverse right subtree
        self.inOrderTraversal(root.right, k, count, result)

    # Return the kth smallest element in the given BST
    def kthSmallest(self, root, k):
        result = [-1]  # Stores the kth smallest element
        count = [0]    # Counter to track the k-th element
        self.inOrderTraversal(root, k, count, result)
        return result[0]
