/*
class Node {
  public:
    int data;
    Node* next;
    Node(int x) {
        data = x;
        next = NULL;
    }
};
*/

class Solution {
    Node* reverseList(Node* head){
        Node *prev = NULL;
        Node *curr = head;
        Node *next = head;
        while(curr){
            next = next -> next;
            curr -> next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
  public:
    Node* addTwoLists(Node* head1, Node* head2) {
        // Q. Add Number Linked Lists
        // code here
        Node *rNum1 = reverseList(head1);
        Node *rNum2 = reverseList(head2);
        int carry = 0;
        Node *head = new Node(-1);
        Node *tail = head;
        while(rNum1 || rNum2 || carry){
            int operand1 = rNum1 ? rNum1 -> data : 0;
            int operand2 = rNum2 ? rNum2 -> data : 0;
            
            int sum = operand1 + operand2 + carry;
            int digit = sum % 10;
            carry = sum / 10;
            
            tail -> next = new Node(digit);
            tail = tail -> next;
            
            if(rNum1) rNum1 = rNum1 -> next;
            if(rNum2) rNum2 = rNum2 -> next;
        }
        
        head = reverseList(head -> next);
        while(head && head -> data == 0){
            head = head -> next;
        }
        
        return head;
    }
};