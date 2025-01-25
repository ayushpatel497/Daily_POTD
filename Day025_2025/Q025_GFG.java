class Q025_GFG {
    public static Node findFirstNode(Node head) {
        Node slow = head, fast = head;

        // Detect loop using Floyd's cycle-finding algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Loop detected
            if (slow == fast) {
                slow = head;

                // Find the first node of the loop
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow; // First node of the loop
            }
        }

        return null; // No loop
    }
}
