import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public ArrayList<Integer> findSpiral(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<Node> s1 = new Stack<>(); // For levels to be printed right to left
        Stack<Node> s2 = new Stack<>(); // For levels to be printed left to right

        s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                Node temp = s1.pop();
                result.add(temp.data);
                // Right to left
                if (temp.right != null) s2.push(temp.right);
                if (temp.left != null) s2.push(temp.left);
            }
            while (!s2.isEmpty()) {
                Node temp = s2.pop();
                result.add(temp.data);
                // Left to right
                if (temp.left != null) s1.push(temp.left);
                if (temp.right != null) s1.push(temp.right);
            }
        }

        return result;
    }
}
