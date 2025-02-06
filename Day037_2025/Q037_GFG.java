import java.util.HashMap;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Q037_GFG {
    private int preIndex = 0;
    private HashMap<Integer, Integer> inorderIndexMap;

    public Node buildTree(int inorder[], int preorder[]) {
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return constructTree(preorder, 0, inorder.length - 1);
    }

    private Node constructTree(int[] preorder, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) {
            return null;
        }

        int rootValue = preorder[preIndex++];
        Node root = new Node(rootValue);

        int inorderIndex = inorderIndexMap.get(rootValue);

        root.left = constructTree(preorder, inorderStart, inorderIndex - 1);
        root.right = constructTree(preorder, inorderIndex + 1, inorderEnd);

        return root;
    }
}
