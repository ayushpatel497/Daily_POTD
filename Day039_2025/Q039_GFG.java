import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class Q039_GFG {
    private boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }

    private void leftBoundary(Node node, ArrayList<Integer> result) {
        Node curr = node.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                result.add(curr.data);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private void leafNodes(Node node, ArrayList<Integer> result) {
        if (node == null) return;
        if (isLeaf(node)) {
            result.add(node.data);
            return;
        }
        leafNodes(node.left, result);
        leafNodes(node.right, result);
    }

    private void rightBoundary(Node node, ArrayList<Integer> result) {
        Node curr = node.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.add(curr.data);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        // Add elements in reverse order
        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add(temp.get(i));
        }
    }

    public ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        if (!isLeaf(root)) {
            result.add(root.data);
        }

        leftBoundary(root, result);
        leafNodes(root, result);
        rightBoundary(root, result);

        return result;
    }
}
