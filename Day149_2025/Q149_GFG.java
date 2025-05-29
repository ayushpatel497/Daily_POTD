class Q149_GFG {
    private void helper(Node root, int sum, int len, int[] maxLen, int[] maxSum) {
        if (root == null) {
            if (len > maxLen[0]) {
                maxLen[0] = len;
                maxSum[0] = sum;
            } else if (len == maxLen[0] && sum > maxSum[0]) {
                maxSum[0] = sum;
            }
            return;
        }

        helper(root.left, sum + root.data, len + 1, maxLen, maxSum);
        helper(root.right, sum + root.data, len + 1, maxLen, maxSum);
    }

    public int sumOfLongRootToLeafPath(Node root) {
        if (root == null) return 0;
        int[] maxSum = {Integer.MIN_VALUE};
        int[] maxLen = {0};
        helper(root, 0, 0, maxLen, maxSum);
        return maxSum[0];
    }
}
