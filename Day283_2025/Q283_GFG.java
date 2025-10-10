import java.util.*;

class Q283_GFG {
    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                temp.add(node.data);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            if (!leftToRight) {
                Collections.reverse(temp);
            }
            ans.addAll(temp);
            leftToRight = !leftToRight;
        }

        return ans;
    }
}
