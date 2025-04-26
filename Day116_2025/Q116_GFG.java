class Q116_GFG {
    public boolean isHeap(Node tree) {
        int totalNodes = countNodes(tree);
        return isComplete(tree, 0, totalNodes) && checkHeap(tree);
    }

    private int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private boolean isComplete(Node root, int index, int totalNodes) {
        if (root == null) return true;
        if (index >= totalNodes) return false;
        return isComplete(root.left, 2 * index + 1, totalNodes) &&
               isComplete(root.right, 2 * index + 2, totalNodes);
    }

    private boolean checkHeap(Node root) {
        if (root.left == null && root.right == null) return true;
        
        if (root.right == null)
            return (root.data >= root.left.data) && checkHeap(root.left);
        
        return (root.data >= root.left.data) &&
               (root.data >= root.right.data) &&
               checkHeap(root.left) && checkHeap(root.right);
    }
}
