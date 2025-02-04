class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Q035_GFG {
    private int diameterOfTree = 0;
    
    private int getDiameter(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getDiameter(root.left);
        int rightHeight = getDiameter(root.right);
        diameterOfTree = Math.max(diameterOfTree, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int diameter(Node root) {
        // Diameter of a Binary Tree
        getDiameter(root);
        return diameterOfTree;
    }
}
