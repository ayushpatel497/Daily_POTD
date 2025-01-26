class Q026_GFG {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        if (head == null || head.next == null)
            return;

        Node slow = head, fast = head;

        // Detect loop using Floyd's Cycle-Finding Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // Loop detected
                break;
            }
        }

        // If no loop is found, return
        if (slow != fast) {
            return;
        }

        // Move slow to head. Keep fast at the meeting point.
        slow = head;

        // Special case when the loop starts at the head
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
        } else {
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        // Remove the loop
        fast.next = null;
    }
}
