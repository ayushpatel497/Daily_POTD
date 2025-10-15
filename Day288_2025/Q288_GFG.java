class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Q288_GFG {

    private void inorder(Node root, int k, int[] counter, int[] result) {
        if (root == null || counter[0] >= k) {
            return;
        }

        inorder(root.left, k, counter, result);

        counter[0]++;
        if (counter[0] == k) {
            result[0] = root.data;
            return;
        }

        inorder(root.right, k, counter, result);
    }

    public int kthSmallest(Node root, int k) {
        int[] counter = new int[1]; // acts like reference variable
        int[] result = new int[1];
        inorder(root, k, counter, result);
        return result[0];
    }
}
