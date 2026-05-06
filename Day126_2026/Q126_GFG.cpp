/*
Definition for Node
struct Node {
    int data;
    struct Node* left;
    struct Node* right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};
*/
class Solution {
  public:
    int getSize(Node* root) {
        // Q. Size of Binary Tree
        // code here
        if(root == nullptr) return 0;
        return 1 + getSize(root-> left) + getSize(root-> right);
    }
};