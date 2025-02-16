import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Q047_GFG {
    // Function to serialize a tree and return a list containing nodes of tree.
    public ArrayList<Integer> serialize(Node root) {
        ArrayList<Integer> serializedList = new ArrayList<>();
        if (root == null) {
            return serializedList;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == null) {
                serializedList.add(-1);
            } else {
                serializedList.add(current.data);
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        return serializedList;
    }

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> arr) {
        if (arr.isEmpty() || arr.get(0) == -1) {
            return null;
        }

        Node root = new Node(arr.get(0));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i < arr.size()) {
            Node current = queue.poll();

            // Left Child
            if (arr.get(i) != -1) {
                current.left = new Node(arr.get(i));
                queue.add(current.left);
            }
            i++;

            // Right Child
            if (i < arr.size() && arr.get(i) != -1) {
                current.right = new Node(arr.get(i));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
};
