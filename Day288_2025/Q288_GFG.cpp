/*
class Node {
  public:
    int data;
    Node* left;
    Node* right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};
*/

class Solution {
    void recursiveCall(Node* root, int k, int& kthSmallestVal, int& counter){
        if(!root || counter >= k){
            return;
        }
        recursiveCall(root -> left, k, kthSmallestVal, counter);
        counter += 1;
        if(counter == k){
            kthSmallestVal = root -> data;
            return;
        }
        recursiveCall(root -> right, k, kthSmallestVal, counter);
    }
  public:
    int kthSmallest(Node *root, int k) {
        // Q. k-th Smallest in BST
        // code here
        int kthSmallestVal = -1;
        int counter = 0;
        recursiveCall(root, k, kthSmallestVal, counter);
        return kthSmallestVal;
    }
};