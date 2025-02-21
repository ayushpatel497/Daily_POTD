import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Q052_Leetcode {
    private Set<Integer> seen = new HashSet<>();

    // BFS to recover the tree and store recovered values in 'seen'
    private void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            seen.add(currentNode.val);
            if (currentNode.left != null) {
                currentNode.left.val = currentNode.val * 2 + 1;
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                currentNode.right.val = currentNode.val * 2 + 2;
                queue.offer(currentNode.right);
            }
        }
    }

    public Q052_Leetcode(TreeNode root) {
        // Recover the tree via BFS
        bfs(root);
    }
    
    public boolean find(int target) {
        return seen.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
