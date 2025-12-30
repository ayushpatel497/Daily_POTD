class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Q364_GFG {

    private Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public Node addTwoLists(Node head1, Node head2) {
        // reverse both lists
        Node rNum1 = reverseList(head1);
        Node rNum2 = reverseList(head2);

        int carry = 0;
        Node dummy = new Node(-1);
        Node tail = dummy;

        while (rNum1 != null || rNum2 != null || carry != 0) {
            int op1 = (rNum1 != null) ? rNum1.data : 0;
            int op2 = (rNum2 != null) ? rNum2.data : 0;

            int sum = op1 + op2 + carry;
            carry = sum / 10;
            int digit = sum % 10;

            tail.next = new Node(digit);
            tail = tail.next;

            if (rNum1 != null) rNum1 = rNum1.next;
            if (rNum2 != null) rNum2 = rNum2.next;
        }

        // reverse result
        Node head = reverseList(dummy.next);

        // remove leading zeros
        while (head != null && head.data == 0) {
            head = head.next;
        }

        return head;
    }
}
