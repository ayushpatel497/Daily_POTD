/*
class Node {
  public:
    int data;
    Node *left;
    Node *right;

    Node(int x) {
        data = x;
        left = NULL;
        right = NULL;
    }
}; */

class Solution {
    int ans = -1;
  public:
    int findMaxFork(Node* root, int k) {
        // Q. Closest Neighbour in BST
        // code here
        if(root == nullptr)
            return 0;
        if(root -> data <= k)
            ans = max(ans, root -> data);
        if(root -> data > k)
            findMaxFork(root -> left, k);
        if(root -> data < k)
            findMaxFork(root -> right, k);
        return ans;
    }
};