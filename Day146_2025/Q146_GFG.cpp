/* structure for a node
class Node {
 public:
  int data;
  Node *next;

  Node(int x){
      data = x;
      next = NULL;
  }
}; */

class Solution {
  public:
    Node* sortedInsert(Node* head, int data) {
        // Q. Insert in Sorted Circular Linked List
        // code here
        Node* newNode = new Node(data); 
        
        if (head == nullptr) {
            newNode->next = newNode; 
            head = newNode;
            return head;
        }
        
        Node* curr = head;
        Node* nextToCurr = head->next;
        
        if (data <= head->data) {
            Node* lastNode = head;
            while (lastNode->next != head) {
                lastNode = lastNode->next; 
            }
            newNode->next = head; 
          	lastNode->next = newNode; 
          	head = newNode; 
            return head;
        }
        
        while (curr->next != head) {
            if (curr->data < data && nextToCurr->data >= data) {
                newNode->next = curr->next; 
                curr->next = newNode;
                return head;
            } 
            else {
                curr = curr->next; 
                nextToCurr = nextToCurr->next; 
            }
        }
        
        newNode->next = head; 
        curr->next = newNode; 
        return head;
    }
};