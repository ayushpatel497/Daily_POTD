/*
class Node {
public:
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};
*/
class Solution {
    int solve(Node* root, int &maxSum) {
        if (root == NULL)
            return 0;
        int left = max(0, solve(root->left, maxSum));
        int right = max(0, solve(root->right, maxSum));
        int currPathSum = root->data + left + right;
        maxSum = max(maxSum, currPathSum);
        return root->data + max(left, right);
    }
  public:
    int findMaxSum(Node *root) {
        // Q. Maximum path sum
        // code here
        int maxSum = INT_MIN;
        solve(root, maxSum);
        return maxSum;
    }
};