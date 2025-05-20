class Solution {
    static class Result {
        int ans = 0;
    }

    private static int findDepth(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(findDepth(root.left), findDepth(root.right));
    }

    private static int findTarget(Node root, int target, Result result) {
        if (root == null) return -1;

        if (root.data == target) {
            result.ans = Math.max(result.ans, findDepth(root) - 1);
            return 1;
        }

        int left = findTarget(root.left, target, result);
        if (left != -1) {
            int depth = findDepth(root.right);
            result.ans = Math.max(result.ans, left + depth);
            return left + 1;
        }

        int right = findTarget(root.right, target, result);
        if (right != -1) {
            int depth = findDepth(root.left);
            result.ans = Math.max(result.ans, right + depth);
            return right + 1;
        }

        return -1;
    }

    public static int minTime(Node root, int target) {
        Result result = new Result();
        findTarget(root, target, result);
        return result.ans;
    }
}
