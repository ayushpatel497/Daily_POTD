import java.util.*;

class Q280_GFG {
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        TreeMap<Integer, Integer> map = new TreeMap<>(); // stores (hd -> node.data)
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            Node node = temp.node;
            int hd = temp.hd;

            // For bottom view, keep updating the map
            map.put(hd, node.data);

            if (node.left != null) {
                q.add(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, hd + 1));
            }
        }

        for (int val : map.values()) {
            ans.add(val);
        }
        return ans;
    }
}

class Pair {
    Node node;
    int hd;
    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}
