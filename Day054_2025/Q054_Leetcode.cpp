/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
 class Solution {
    TreeNode* constructTree(int& preIndex, int& postIndex, vector<int>& preorder, vector<int>& postorder) {
        TreeNode* root = new TreeNode(preorder[preIndex]);
        preIndex++;
        if (root->val != postorder[postIndex]) {
            root->left = constructTree(preIndex, postIndex, preorder, postorder);
        }
        if (root->val != postorder[postIndex]) {
            root->right = constructTree(preIndex, postIndex, preorder, postorder);
        }
        postIndex++;

        return root;
    }
public:
    TreeNode* constructFromPrePost(vector<int>& preorder, vector<int>& postorder) {
        // Q. Construct Binary Tree from Preorder and Postorder Traversal
        int preIndex = 0;
        int postIndex = 0;
        return constructTree(preIndex, postIndex, preorder, postorder);
    }
};