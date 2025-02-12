class Q043_GFG {
    // Helper function for in-order traversal
    private void inOrderTraversal(Node root, int k, int[] result, int[] count) {
        if (root == null || count[0] >= k) {
            return;
        }
        
        // Recur for left subtree
        inOrderTraversal(root.left, k, result, count);
        
        // Increment counter
        count[0]++;
        if (count[0] == k) {
            result[0] = root.data;
            return;
        }
        
        // Recur for right subtree
        inOrderTraversal(root.right, k, result, count);
    }

    // Return the Kth smallest element in the given BST
    public int kthSmallest(Node root, int k) {
        int[] result = {-1}; // Stores the kth smallest value
        int[] count = {0};   // Counter to track the kth element
        inOrderTraversal(root, k, result, count);
        return result[0];
    }
}
