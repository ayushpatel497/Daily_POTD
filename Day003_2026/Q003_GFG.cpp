/*
class Node {
public:
    int data;
    Node* next;
    Node* bottom;

    Node(int x) {
        data = x;
        next = NULL;
        bottom = NULL;
    }
};
*/

class Solution {
    Node* mergeTwoLists(Node* list1, Node* list2) {
        Node *root = new Node(-1);
        Node *curr = root;
        while(list1 && list2){
            if(list1 -> data <= list2 -> data){
                curr -> bottom = list1;
                list1 = list1 -> bottom;
            }
            else{
                curr -> bottom = list2;
                list2 = list2 -> bottom;
            }
            curr -> next = NULL;
            curr = curr -> bottom;
        }
        if(list1){
            curr -> bottom = list1;
        }
        if(list2){
            curr -> bottom = list2;
        }
        
        if(root -> bottom){
            root -> bottom -> next = NULL;
        }

        return root -> bottom;
    }
    
  public:
    Node *flatten(Node *root) {
        // Q. Flattening a Linked List
        // code here
        if(!root || !root -> next){
            return root;
        }
        Node* mergedRoot = flatten(root->next);
        root = mergeTwoLists(root, mergedRoot);
        return root;
    }
};