class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}


class Q246_GFG {
    public Node reverse(Node head) {
        if (head == null) return null;
        if (head.next == null) return head;

        Node fast = head;
        while (fast.next != null) fast = fast.next;

        Node slow = head;
        while (slow != fast && slow.prev != fast) {
            int temp = slow.data;
            slow.data = fast.data;
            fast.data = temp;

            slow = slow.next;
            fast = fast.prev;
        }
        return head;
    }
}
