class Q040_GFG {
    // Helper function to compute the maximum path sum
    private int height(Node root, int[] ans) {
        if (root == null) 
            return 0;
        
        int leftSum = Math.max(0, height(root.left, ans));
        int rightSum = Math.max(0, height(root.right, ans));

        ans[0] = Math.max(ans[0], leftSum + rightSum + root.data);
        
        return root.data + Math.max(leftSum, rightSum);
    }

    // Function to return maximum path sum from any node in a tree.
    public int findMaxSum(Node root) {
        int[] ans = new int[]{Integer.MIN_VALUE};
        height(root, ans);
        return ans[0];
    }
}
