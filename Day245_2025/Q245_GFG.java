/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node swapKth(Node head, int k) {
        if (head == null) return head;

        // Step 1: Count length
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        k--; // zero-based index
        int start = k, end = size - k - 1;
        Node node1 = null, node2 = null;

        temp = head;
        int cnt = 0;
        while (temp != null) {
            if (cnt == start) node1 = temp;
            if (cnt == end) node2 = temp;
            temp = temp.next;
            cnt++;
        }

        if (node1 != null && node2 != null) {
            int val = node1.data;
            node1.data = node2.data;
            node2.data = val;
        }

        return head;
    }
}
