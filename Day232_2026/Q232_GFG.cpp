/* Structure of Binary Tree Node
class Node {
  public:
    int data;
    Node *left;
    Node *right;
    Node(int val) {
        data = val;
        left = right = nullptr;
    }
};*/

class Solution {
    int solve(Node* root, int& ans) {
        if (!root) {
            return 1e9;
        }
        int left = solve(root-> left, ans);
        int right = solve(root-> right, ans);
        ans = max(ans, root-> data - left);
        ans = max(ans, root-> data - right);

        return min({root-> data, left, right});
    }
  public:
    int maxDiff(Node* root) {
        // Q. Node and Ancestor Max Diff
        // code here
        int ans = INT_MIN;
        solve(root, ans);

        return ans;
    }
};