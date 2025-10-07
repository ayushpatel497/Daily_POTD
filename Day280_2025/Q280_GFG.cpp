/*
class Node {
public:
    int data;
    Node* left;
    Node* right;

    Node(int x) {
        data = x;
        left = right = NULL;
    }
};
*/

class Solution {
  public:
    vector<int> bottomView(Node *root) {
        // Q. Bottom View of Binary Tree
        // code here
        vector<int> ans;
        if(!root){
            return ans;
        }
        map<int, int> nodeMap;
        queue<pair<Node *, int>> viewQueue;
        viewQueue.push({root, 0});
        while(!viewQueue.empty()){
            auto iterator = viewQueue.front();
            viewQueue.pop();
            Node* currentNode = iterator.first;
            int line = iterator.second;
            nodeMap[line] = currentNode -> data;
            if(currentNode -> left){
                viewQueue.push({currentNode -> left, line - 1});
            }
            if(currentNode -> right){
                viewQueue.push({currentNode -> right, line + 1});
            }
        }
        
        for(auto keyValue : nodeMap){
            ans.emplace_back(keyValue.second);
        }
        return ans;
    }
};