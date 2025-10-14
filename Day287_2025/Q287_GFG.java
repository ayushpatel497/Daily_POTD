class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Q287_GFG {
    public int nodeSum(Node root, int l, int r) {
        if (root == null) return 0;

        int res = 0;
        if (root.data >= l && root.data <= r)
            res += root.data;

        if (root.left != null)
            res += nodeSum(root.left, l, r);

        if (root.right != null)
            res += nodeSum(root.right, l, r);

        return res;
    }
}
