class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
}

class Q120_GFG {
    public int countNodesinLoop(Node head) {
        if (head == null) return 0;

        Node slow = head, fast = head;

        // Detect loop using Floyd's algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Loop detected; now count the number of nodes in loop
                int count = 1;
                Node temp = slow.next;
                while (temp != slow) {
                    count++;
                    temp = temp.next;
                }
                return count;
            }
        }

        return 0; // No loop
    }
}
