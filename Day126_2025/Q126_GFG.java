import java.util.ArrayList;

class Q126_GFG {
    void leftViewUtil(Node root, int level, ArrayList<Integer> result) {
        if (root == null) return;
        
        if (result.size() == level) {
            result.add(root.data);
        }
        
        leftViewUtil(root.left, level + 1, result);
        leftViewUtil(root.right, level + 1, result);
    }

    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        leftViewUtil(root, 0, result);
        return result;
    }
}
