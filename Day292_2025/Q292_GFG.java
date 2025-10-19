import java.util.*;

class Q292_GFG {
    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    private void inorder(Node root, List<Integer> arr) {
        if (root == null) return;
        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }

    public ArrayList<Integer> getKClosest(Node root, int target, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int num : inorderList) {
            pq.offer(new int[]{Math.abs(target - num), num});
        }

        while (ans.size() < k && !pq.isEmpty()) {
            ans.add(pq.poll()[1]);
        }

        return ans;
    }
}
