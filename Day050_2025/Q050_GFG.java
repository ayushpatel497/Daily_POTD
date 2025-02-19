import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class Compare implements Comparator<Node> {
    public int compare(Node a, Node b) {
        return a.data - b.data;
    }
}

class Q050_GFG {
    // Function to merge K sorted linked lists.
    Node mergeKLists(List<Node> arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Compare());

        // Add all list heads to the priority queue
        for (Node head : arr) {
            if (head != null) {
                pq.add(head);
            }
        }

        Node dummy = new Node(-1);
        Node tail = dummy;

        while (!pq.isEmpty()) {
            Node top = pq.poll();
            tail.next = top;
            tail = top;
            
            if (top.next != null) {
                pq.add(top.next);
            }
        }

        return dummy.next;
    }
}
