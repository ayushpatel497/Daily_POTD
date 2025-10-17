class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

class Q290_GFG {
    private static int solve(Node root, int sum) {
        if (root == null) return 0;

        int right = solve(root.right, sum);
        int left = solve(root.left, root.data + right + sum);

        int total = root.data + left + right;
        root.data = right + sum;

        return total;
    }

    public static void transformTree(Node root) {
        solve(root, 0);
    }
}
