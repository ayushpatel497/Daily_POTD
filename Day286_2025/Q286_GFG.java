import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Q286_GFG {
    private Map<Node, Integer> dp = new HashMap<>();

    private int recursive(Node root) {
        if (root == null) return 0;
        if (dp.containsKey(root)) return dp.get(root);

        int skip1 = recursive(root.left);
        int skip2 = recursive(root.right);

        int a = 0, b = 0, c = 0, d = 0;

        if (root.left != null) {
            a = recursive(root.left.left);
            b = recursive(root.left.right);
        }
        if (root.right != null) {
            c = recursive(root.right.left);
            d = recursive(root.right.right);
        }

        int include = root.data + a + b + c + d;
        int exclude = skip1 + skip2;

        int res = Math.max(include, exclude);
        dp.put(root, res);
        return res;
    }

    public int getMaxSum(Node root) {
        return recursive(root);
    }
}
