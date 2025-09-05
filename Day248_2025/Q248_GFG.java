class Q248_GFG {
    public Node segregate(Node head) {
        if (head == null) return head;

        Node curr = head;
        int cntZero = 0, cntOne = 0, cntTwo = 0;

        // Count occurrences of 0, 1, and 2
        while (curr != null) {
            if (curr.data == 0) cntZero++;
            else if (curr.data == 1) cntOne++;
            else cntTwo++;
            curr = curr.next;
        }

        // Rewrite linked list with sorted values
        curr = head;
        while (curr != null) {
            if (cntZero > 0) {
                curr.data = 0;
                cntZero--;
            } else if (cntOne > 0) {
                curr.data = 1;
                cntOne--;
            } else {
                curr.data = 2;
                cntTwo--;
            }
            curr = curr.next;
        }

        return head;
    }
}
