import java.util.*;

class Q147_GFG {
    public ArrayList<Integer> leafNodes(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> leaves = new ArrayList<>();
        int n = preorder.length;

        for (int i = 0, j = 1; j < n; i++, j++) {
            boolean found = false;

            if (preorder[i] > preorder[j]) {
                stack.push(preorder[i]);
            } else {
                while (!stack.isEmpty() && preorder[j] > stack.peek()) {
                    stack.pop();
                    found = true;
                }
            }

            if (found) {
                leaves.add(preorder[i]);
            }
        }

        // Add the last node as a leaf
        leaves.add(preorder[n - 1]);
        return leaves;
    }
}
