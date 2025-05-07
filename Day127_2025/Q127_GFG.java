import java.util.*;

class Q127_GFG {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        traversePaths(root, path, ans);
        return ans;
    }

    private static void traversePaths(Node root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ans) {
        if (root == null) return;

        path.add(root.data);

        if (root.left == null && root.right == null) {
            ans.add(new ArrayList<>(path)); // add a copy of the current path
        } else {
            if (root.left != null) traversePaths(root.left, path, ans);
            if (root.right != null) traversePaths(root.right, path, ans);
        }

        path.remove(path.size() - 1); // backtrack
    }
}
