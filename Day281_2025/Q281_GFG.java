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

class Q281_GFG {
    private Map<Integer, Integer> postIndex;
    private int preIndex = 0;

    public Node constructTree(int[] pre, int[] post) {
        postIndex = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            postIndex.put(post[i], i);
        }
        return build(pre, post, 0, post.length - 1);
    }

    private Node build(int[] pre, int[] post, int start, int end) {
        if (preIndex >= pre.length || start > end)
            return null;

        Node root = new Node(pre[preIndex++]);

        if (start == end || preIndex >= pre.length)
            return root;

        int idx = postIndex.get(pre[preIndex]);
        root.left = build(pre, post, start, idx);
        root.right = build(pre, post, idx + 1, end - 1);

        return root;
    }
}
