/*
class Node {
  public:
    int data;
    Node *next;

    Node(int x) {
       data = x;
       next = NULL;
    }
};
*/

class Solution {
    Node* reverse(Node* head){
        Node* prev = NULL;
        Node* f;
        
        while(head!=NULL){
            f = head->next;
            head->next = prev;
            prev = head;
            head = f;
        }
        return prev;
    }
  public:
    bool isPalindrome(Node *head) {
        //  code here
        Node* s = head;
        Node* f = head;
        
        while(f && f->next){
            s=s->next;
            f=f->next->next;
        }
        
        Node* first = head;
        Node*  second = reverse(s);
        
        
        while(second){
            if(first->data != second->data)return false;
            second=second->next;
            first=first->next;
        }
        
        return true;
    }
};