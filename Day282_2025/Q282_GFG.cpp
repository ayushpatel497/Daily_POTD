/*
class Node {
  public:
    int data;
    Node* left;
    Node* right;

    Node(int val) {
        data = val;
        left = NULL;
        right = NULL;
    }
};
*/

class Solution {
    vector<int> postOrd;
  public:
    vector<int> postOrder(Node* root) {
        // Q. Postorder Traversal
        // code here
        if(root){
            postOrder(root->left);
            postOrder(root->right);
            postOrd.push_back(root->data);
        }
        return postOrd;
    }
};