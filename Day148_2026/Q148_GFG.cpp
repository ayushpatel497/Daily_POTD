/* Structure of binary tree node
class Node{
public:
    int data;
    Node* left, right;
    Node(int item)
    {
        data = item;
        left = nullptr;
        right = nullptr;
    }
}
*/
class Solution {
    void dfs(Node* root, map<int, int>& mp, int x){
        if(root == NULL) return;
        mp[x] += root-> data;
        dfs(root-> left, mp, x - 1);
        dfs(root-> right, mp, x + 1);
    }
  public:
    vector<int> verticalSum(Node* root) {
        // Q. Vertical Sum
        // code here
        map<int, int> mp;
        vector<int> ans;
        dfs(root, mp, 0);
        for(auto x: mp){
            ans.push_back(x.second);
        }
        
        return ans;
    }
};