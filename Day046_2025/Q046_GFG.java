class Q046_GFG {
    Node LCA(Node root, Node n1, Node n2) {
        if (root == null) return null;

        // If both nodes are greater than root, LCA is in the right subtree
        if (root.data < n1.data && root.data < n2.data) {
            return LCA(root.right, n1, n2);
        }
        
        // If both nodes are smaller than root, LCA is in the left subtree
        else if (root.data > n1.data && root.data > n2.data) {
            return LCA(root.left, n1, n2);
        }
        
        // If one node is on the left and the other is on the right (or one is the root), return root
        return root;
    }
}
