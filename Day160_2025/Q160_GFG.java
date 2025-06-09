class Q160_GFG {
    boolean solve(Node root, int mini, int maxi) {
        if (root.left == null && root.right == null) {
            return mini == maxi;
        }

        if (root.left != null && solve(root.left, mini, root.data - 1))
            return true;

        if (root.right != null && solve(root.right, root.data + 1, maxi))
            return true;

        return false;
    }

    public boolean isDeadEnd(Node root) {
        return solve(root, 1, Integer.MAX_VALUE);
    }
}
