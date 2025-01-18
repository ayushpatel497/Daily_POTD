// Node class
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Q018_GFG {
    Node reverseList(Node head) {
        // Q. Reverse a linked list
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next; // Store the next node
            curr.next = prev; // Reverse the current node's pointer
            prev = curr; // Move prev to the current node
            curr = next; // Move to the next node
        }

        return prev; // New head of the reversed list
    }
}

// Driver Code
class Main {
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.println("Enter the number of test cases:");
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            System.out.println("Enter the linked list elements separated by space:");
            String[] elements = sc.nextLine().split(" ");
            Node head = null, tail = null;

            for (String element : elements) {
                int val = Integer.parseInt(element);
                if (head == null) {
                    head = new Node(val);
                    tail = head;
                } else {
                    tail.next = new Node(val);
                    tail = tail.next;
                }
            }

            Q018_GFG ob = new Q018_GFG();
            head = ob.reverseList(head);

            System.out.println("Reversed List:");
            printList(head);
            System.out.println("~");
        }

        sc.close();
    }
}
