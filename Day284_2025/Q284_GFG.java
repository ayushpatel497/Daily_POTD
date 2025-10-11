class Q284_GFG {

    private int solve(Node root, int[] maxSum) {
        if (root == null)
            return 0;

        int left = Math.max(0, solve(root.left, maxSum));
        int right = Math.max(0, solve(root.right, maxSum));

        int currPathSum = root.data + left + right;
        maxSum[0] = Math.max(maxSum[0], currPathSum);

        return root.data + Math.max(left, right);
    }

    int findMaxSum(Node root) {
        int[] maxSum = new int[]{Integer.MIN_VALUE};
        solve(root, maxSum);
        return maxSum[0];
    }
}
