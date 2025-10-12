class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Q285_GFG {
    int moves;

    private int distribute(Node root) {
        if (root == null) return 0;

        int left = distribute(root.left);
        int right = distribute(root.right);

        moves += Math.abs(left) + Math.abs(right);

        return root.data + left + right - 1;
    }

    public int distCandy(Node root) {
        moves = 0;
        distribute(root);
        return moves;
    }
}
