class Q036_GFG {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        if (node == null) {
            return;
        }

        // Swap left and right children
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        // Recursively call for left and right subtrees
        mirror(node.left);
        mirror(node.right);
    }
}
