import java.util.*;
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Q103_GFG {
    private Node clone(Node node, Map<Integer, Node> visited) {
        if (visited.containsKey(node.val)) return visited.get(node.val);

        Node newNode = new Node(node.val);
        visited.put(node.val, newNode);

        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(clone(neighbor, visited));
        }

        return newNode;
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return clone(node, new HashMap<>());
    }
}

