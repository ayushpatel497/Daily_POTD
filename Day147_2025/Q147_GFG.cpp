class Solution {
  public:
    vector<int> leafNodes(vector<int>& preorder) {
        // Q. Print leaf nodes from preorder traversal of BST
        // code here
        stack<int> s; 
        vector<int> leaves;
        int n = preorder.size();
        for (int i = 0, j = 1; j < n; i++, j++) {
            bool found = false;
            if (preorder[i] > preorder[j]) {
                s.push(preorder[i]);
            } 
            else {
                while (!s.empty()) {
                    if (preorder[j] > s.top()) {
                        s.pop();
                        found = true; 
                    } 
                    else {
                        break;
                    }
                }
            }
            if (found) {
                leaves.push_back(preorder[i]);
            }
        }
        leaves.push_back(preorder[n - 1]);
        return leaves; 
    }
};