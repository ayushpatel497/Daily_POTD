import java.util.Stack;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {
    public boolean findTarget(Node root, int target) {
        if (root == null) return false;

        Stack<Node> s1 = new Stack<>(); // For in-order traversal (left to right)
        Stack<Node> s2 = new Stack<>(); // For reverse in-order traversal (right to left)

        Node temp1 = root, temp2 = root;

        while (true) {
            while (temp1 != null) {
                s1.push(temp1);
                temp1 = temp1.left;
            }
            while (temp2 != null) {
                s2.push(temp2);
                temp2 = temp2.right;
            }

            if (s1.isEmpty() || s2.isEmpty()) break;

            temp1 = s1.peek();
            temp2 = s2.peek();

            if (temp1 == temp2) return false; // Prevent duplicate nodes

            int sum = temp1.data + temp2.data;

            if (sum == target) return true;
            else if (sum < target) {
                s1.pop();
                temp1 = temp1.right;
                temp2 = null; // Don't move right stack
            } else {
                s2.pop();
                temp2 = temp2.left;
                temp1 = null; // Don't move left stack
            }
        }

        return false;
    }
}
