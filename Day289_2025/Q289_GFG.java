class Q289_GFG {
    // simple Node definition so the type is resolved
    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    Node removekeys(Node root, int l, int r) {
        if (root == null) return null;

        // If current node is smaller than L, then its left subtree is useless
        if (root.data < l)
            return removekeys(root.right, l, r);

        // If current node is greater than R, then its right subtree is useless
        if (root.data > r)
            return removekeys(root.left, l, r);

        // Otherwise, fix the left and right subtrees
        root.left = removekeys(root.left, l, r);
        root.right = removekeys(root.right, l, r);

        return root;
    }
}
