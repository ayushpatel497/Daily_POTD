class Q150_GFG {
    int ans = -1;

    public int findMaxFork(Node root, int k) {
        if (root == null) return ans;

        if (root.data <= k) {
            ans = Math.max(ans, root.data);
            findMaxFork(root.right, k);  // Go right to check for a closer value
        } else {
            findMaxFork(root.left, k);   // Go left to find smaller values
        }

        return ans;
    }
}
