/*
class Node {
public:
    int data;
    Node* left;
    Node* right;

    Node(int x) {
        data = x;
        left = right = nullptr;
    }
};
*/

class Solution {
    int move;
    int dist(Node* node){
        if(!node) return 0;
        int l = dist(node -> left);
        int r = dist(node -> right);
        move += abs(l) + abs(r);
        return node -> data + l + r - 1; 
    }
  public:
    int distCandy(Node* root) {
        // Q. Distribute Candies
        // code here
        move = 0;
        dist(root);
        return move;
    }
};