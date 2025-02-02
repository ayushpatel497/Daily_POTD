import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Q033_GFG {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levelOrderTraversal = new ArrayList<>();
        if (root == null) return levelOrderTraversal;

        Queue<Node> nodesQueue = new LinkedList<>();
        nodesQueue.offer(root);

        while (!nodesQueue.isEmpty()) {
            int size = nodesQueue.size();
            List<Integer> levelNodes = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node currentNode = nodesQueue.poll();
                levelNodes.add(currentNode.data);

                if (currentNode.left != null) {
                    nodesQueue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    nodesQueue.offer(currentNode.right);
                }
            }
            levelOrderTraversal.add(levelNodes);
        }
        return levelOrderTraversal;
    }
}
