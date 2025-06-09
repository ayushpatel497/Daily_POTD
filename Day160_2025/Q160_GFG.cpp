/*The Node structure is
class Node
{
    int data;
    struct Node *left;
    struct Node *right;

    Node(int x){
        data = x;
        left = NULL;
        right = NULL;
    }
};*/

class Solution {
    bool solve(Node* root,int mini,int maxi){
        if(!root->left && !root->right){
            if(mini==maxi) return true;
            return false;
        }  
        if(root->left && solve(root->left,mini,root->data-1)) return true;
        if(root->right && solve(root->right,root->data+1,maxi)) return true;
        return false;
    }
  public:
    bool isDeadEnd(Node *root) {
        // Q. BST with Dead End
        // Code here
        return solve(root,1,INT_MAX);
    }
};