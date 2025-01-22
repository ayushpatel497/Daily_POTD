class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Q022_GFG {
    public static Node addTwoLists(Node num1, Node num2) {
        Node rNum1 = reverseList(num1);
        Node rNum2 = reverseList(num2);

        int carry = 0;
        Node dummyHead = new Node(-1);
        Node tail = dummyHead;

        while (rNum1 != null || rNum2 != null || carry != 0) {
            int operand1 = (rNum1 != null) ? rNum1.data : 0;
            int operand2 = (rNum2 != null) ? rNum2.data : 0;

            int sum = operand1 + operand2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            tail.next = new Node(digit);
            tail = tail.next;

            if (rNum1 != null) rNum1 = rNum1.next;
            if (rNum2 != null) rNum2 = rNum2.next;
        }

        Node result = reverseList(dummyHead.next);

        // Remove leading zeros
        while (result != null && result.data == 0) {
            result = result.next;
        }

        return result;
    }

    private static Node reverseList(Node head) {
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
