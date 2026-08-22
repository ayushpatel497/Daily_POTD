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
}; */

class Solution {
    bool findPath(Node* root, int target, vector<char>& path) {
        if (root == nullptr) return false;
        if (root->data == target) return true;
        path.push_back('L');
        if (findPath(root->left, target, path)) return true;
        path.pop_back();
        path.push_back('R');
        if (findPath(root->right, target, path)) return true;
        path.pop_back();

        return false;
    }
  public:
    int numberOfTurns(Node* root, int p, int q) {
        // Q. Number of Turns in Binary Tree
        // code here
        vector<char> pathP, pathQ;
        findPath(root, p, pathP);
        findPath(root, q, pathQ);
        int i = 0;
        while (i < pathP.size() && i < pathQ.size() &&
               pathP[i] == pathQ[i]) {
            i++;
        }
        vector<char> path;
        for (int j = (int)pathP.size() - 1; j >= i; j--) {
            path.push_back(pathP[j]);
        }
        for (int j = i; j < pathQ.size(); j++) {
            path.push_back(pathQ[j]);
        }
        if (path.size() < 2) return -1;
        int turns = 0;
        for (int j = 1; j < path.size(); j++) {
            if (path[j] != path[j - 1]) {
                turns++;
            }
        }

        return turns == 0 ? -1 : turns;
    }
};