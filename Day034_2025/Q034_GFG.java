class Q034_GFG {
    // Function to find the height of a binary tree.
    int height(Node node) {
        if (node == null) {
            return 0; // Since height of an empty tree is 0
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
