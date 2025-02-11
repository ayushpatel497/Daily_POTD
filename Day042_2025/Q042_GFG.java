class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class Q042_GFG {
    private boolean isValid(Node root, int min, int max) {
        if (root == null) return true;
        if (root.data <= min || root.data >= max) return false;
        return isValid(root.left, min, root.data) && isValid(root.right, root.data, max);
    }

    // Function to check whether a Binary Tree is BST or not.
    public boolean isBST(Node root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
