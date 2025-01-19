class Q019_GFG {
    public Node rotate(Node head, int k) {
        // Edge case: if the list is empty or has only one node
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Count the number of nodes in the list
        Node curr = head;
        int nodes = 1;
        while (curr.next != null) {
            curr = curr.next;
            nodes++;
        }

        // Adjust k to avoid unnecessary rotations
        k %= nodes;
        if (k == 0) {
            return head;
        }

        // Make the list circular
        curr.next = head;

        // Traverse to the (nodes - k)th node
        for (int i = 0; i < nodes - k; i++) {
            curr = curr.next;
        }

        // Update the head and break the loop
        head = curr.next;
        curr.next = null;

        return head;
    }
}