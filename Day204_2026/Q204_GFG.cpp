/*
class Node
{
    int data;
    Node* left;
    Node* right;

    Node(int x){
        data = x;
        left = right = NULL;
    }
};
*/

class Solution {
    void preorderImplementation(Node* root, vector<int>&ans){
        if(root == NULL){
            return ;
        }
        ans.push_back(root-> data);
        preorderImplementation(root-> left, ans);
        preorderImplementation(root-> right, ans);
        
    }
  public:
    vector<int> preOrder(Node* root) {
        // Q. Preorder Traversal
        // code here
        vector<int> ans;
        preorderImplementation(root, ans);
        return ans;
    }
};