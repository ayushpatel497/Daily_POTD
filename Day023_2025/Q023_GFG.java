class Node {
    int data;
    Node next, random;

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}

class Q023_GFG {
    public Node cloneLinkedList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create new nodes and interweave them with the original list
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.data);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // Step 2: Assign random pointers for the newly created nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Detach the original list and the cloned list
        curr = head;
        Node newHead = curr.next;
        Node newCurr = newHead;
        while (curr != null) {
            curr.next = newCurr.next;
            curr = curr.next;
            if (curr != null) {
                newCurr.next = curr.next;
            }
            newCurr = newCurr.next;
        }

        return newHead;
    }
}
