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
    void helper(Node *root, int sum, int len, int &maxLen, int &maxSum)
    {
        if (!root)
        {
            if (maxLen < len)
            {
                maxLen = len;
                maxSum = sum;
            }
            else if (maxLen == len && maxSum < sum)
                maxSum = sum;
            return;
        }
        helper(root->left, sum + root->data, len + 1, maxLen, maxSum);
        helper(root->right, sum + root->data, len + 1, maxLen, maxSum);
    }
  public:
    int sumOfLongRootToLeafPath(Node *root) {
        // Q. Sum of nodes on the longest path
        // code here
        if (!root)
            return 0;
        int maxSum = INT_MIN, maxLen = 0; 
        helper(root, 0, 0, maxLen, maxSum);
        return maxSum;
    }
};