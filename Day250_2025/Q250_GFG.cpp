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

class Compare {
public:
    bool operator()(Node* a, Node* b) {
        return a -> data > b -> data;
    }
};


class Solution {
  public:
    Node* mergeKLists(vector<Node*>& arr) {
        // Q. Merge K sorted linked lists
        // code here
        priority_queue<Node*, vector<Node*>, Compare> pq;
        for (Node* head : arr) {
            if (head != nullptr) pq.push(head);
        }
        Node* dummy = new Node(-1);
        Node* tail = dummy;
        
        while (!pq.empty()) {
            Node* top = pq.top();
            pq.pop();
            tail -> next = top;
            tail = top;
            if (top -> next != nullptr) {
                pq.push(top -> next);
            }
        }
        return dummy -> next;
    }
};