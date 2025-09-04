/*
class Node {
  public:
    int data;
    Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }
};
*/
class Solution {
    Node *getKthNode(Node *head, int k){
        k -= 1;
        while(head -> next && k){
            k -= 1;
            head = head -> next;
        }
        return head;
    }
    
    Node *reverseAList(Node *head){
        Node *prev = NULL, *curr = head, *next = head;
        while(curr){
            next = next -> next;
            curr -> next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
  public:
    Node *reverseKGroup(Node *head, int k) {
        // Q. Linked List Group Reverse
        // code here
        Node *temporary = head;
        Node *previousLast = NULL;
        while(temporary){
            Node *kThNode = getKthNode(temporary, k);
            if(!kThNode){
                if(previousLast){
                    previousLast -> next = temporary;
                }
                break;
            }
            
            Node *nextNode = kThNode -> next;
            kThNode -> next = NULL;
            
            reverseAList(temporary);
            if(temporary == head){
                head = kThNode;
            }
            else{
                previousLast -> next = kThNode;
            }
            
            previousLast = temporary;
            temporary = nextNode;
        }
        return head;
    }
};