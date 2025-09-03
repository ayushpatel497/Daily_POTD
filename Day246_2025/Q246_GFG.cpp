/*
class Node {
  public:
    int data;
    Node *next;
    Node *prev;
    Node(int val) {
        data = val;
        next = NULL;
        prev = NULL;
    }
};

*/
class Solution {
  public:
    Node *reverse(Node *head) {
        // Q. Reverse a Doubly Linked List
        // code here
        if (head == NULL) return NULL;
        if(head -> next == NULL) return head;
        Node* fast = head;
        while(fast -> next != NULL) fast = fast -> next;
        Node* slow = head;
        while(slow != fast && slow -> prev != fast){
            int temp = slow -> data;
            slow -> data = fast -> data;
            fast -> data = temp;
            slow = slow -> next;
            fast = fast -> prev;
        }
        return head;
    }
};