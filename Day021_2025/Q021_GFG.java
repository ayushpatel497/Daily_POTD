class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
}

class Q021_GFG {
    public static Node reverseKGroup(Node head, int k) {
        Node temporary = head;
        Node previousLast = null;
        
        while (temporary != null) {
            Node kthNode = getKthNode(temporary, k);
            if (kthNode == null) {
                if (previousLast != null) {
                    previousLast.next = temporary;
                }
                break;
            }
            
            Node nextNode = kthNode.next;
            kthNode.next = null;
            
            reverseList(temporary);
            
            if (temporary == head) {
                head = kthNode;
            } else {
                previousLast.next = kthNode;
            }
            
            previousLast = temporary;
            temporary = nextNode;
        }
        
        return head;
    }
    
    private static Node getKthNode(Node head, int k) {
        k -= 1;
        while (head != null && k > 0) {
            head = head.next;
            k--;
        }
        return head;
    }
    
    private static void reverseList(Node head) {
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}
