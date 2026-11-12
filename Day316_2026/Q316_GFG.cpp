/* Structure of a Binary Search Tree node
class Node {
  public:
    int data;
    Node* left;
    Node* right;

    Node(int val) {
        data = val;
        left = right = nullptr;
    }
};
*/

class Solution {
  public:
    int minDiff(Node *root, int k) {
        // Q. Closest in BST
        // code here
        int diff = 1e9;
        Node* node = root;
        while(node){
            if(node-> data == k){
                return 0;
            }else if(k > node-> data){
                diff = min(diff, abs(k - node-> data));
                node = node-> right;
            }else{
                diff = min(diff, abs(k - node-> data));
                node = node-> left;
            }
        }
        return diff;
    }
};
