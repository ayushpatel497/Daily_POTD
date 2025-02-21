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
 class FindElements {
    unordered_set<int> seen;
    void bfs(TreeNode* root) {
        queue<TreeNode*> queue;
        root->val = 0;
        queue.push(root);

        while (!queue.empty()) {
            TreeNode* currentNode = queue.front();
            queue.pop();
            seen.insert(currentNode->val);
            if (currentNode->left) {
                currentNode->left->val = currentNode->val * 2 + 1;
                queue.push(currentNode->left);
            }
            if (currentNode->right) {
                currentNode->right->val = currentNode->val * 2 + 2;
                queue.push(currentNode->right);
            }
        }
    }
public:
    FindElements(TreeNode* root) {
        // Q. Find Elements in a Contaminated Binary Tree
        bfs(root);
    }
    
    bool find(int target) {
        return seen.count(target);
    }
};

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements* obj = new FindElements(root);
 * bool param_1 = obj->find(target);
 */