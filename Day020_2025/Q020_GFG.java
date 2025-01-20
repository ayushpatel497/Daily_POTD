class Q020_GFG {
    Node sortedMerge(Node head1, Node head2) {
        // If one of the lists is empty, return the other
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        // Dummy node to simplify the merge process
        Node dummy = new Node(-1);
        Node curr = dummy;

        // Merge the two lists
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        // Append any remaining nodes
        if (head1 != null) curr.next = head1;
        if (head2 != null) curr.next = head2;

        return dummy.next;
    }
}
