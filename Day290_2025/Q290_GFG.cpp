/*
class Node {
  public:
    int data;
    Node* left;
    Node* right;

    Node(int value) {
        data = value;
        left = nullptr;
        right = nullptr;
    }
};*/

class Solution {
    int solve(Node* root, int sum){
        if(!root)return 0;
        int r = solve(root->right, sum);
        int l = solve(root->left, root->data+r+sum);
        int store = root->data+l+r;
        root->data = r+sum;
        return store;
    }
  public:
    void transformTree(Node *root) {
        // Q. BST to greater sum tree
        // code here
        solve(root,0);
    }
};