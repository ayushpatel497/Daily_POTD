/*
class Node {
  public:
    int data;
    Node* left;
    Node* right;

    // Constructor to initialize a new node
    Node(int val) {
        data = val;
        left = NULL;
        right = NULL;
    }
};
*/

class Solution {
  public:
    int nodeSum(Node* root, int l, int r) {
        // Q. Sum of Nodes in BST Range
        // code here
        if(!root) return 0;
        int res = 0;
        if(root -> data >= l && root -> data <= r) 
            res += root -> data;
        if(root -> left)
            res += nodeSum(root -> left, l, r);
        if(root -> right)
            res += nodeSum(root -> right, l, r);
        
        return res;
    }
};
