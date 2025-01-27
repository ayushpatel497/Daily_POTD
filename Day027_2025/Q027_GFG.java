import java.util.*;

class Q027_GFG {
    private class Node {
        int key, value;
        Node prev, next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    // Constructor for initializing the cache capacity with the given value.
    Q027_GFG(int cap) {
        this.capacity = cap;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    // Function to return value corresponding to the key.
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }

    // Function for storing key-value pair.
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
