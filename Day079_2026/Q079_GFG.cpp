
/* BST Node
class Node
{
   public:
    int data;
    Node *left;
    Node *right;

    Node(int x){
        data = x;
        left = NULL;
        right = NULL;
    }
}; */

class Solution {
    Node* pre = NULL;
    Node* succ = NULL;
    int ele1 = INT_MIN;
    int ele2 = INT_MAX;
    void Solve1(Node* root, int key){
      if(root == NULL)
      return;
      if(root-> data < key){
          if(ele1 < root-> data){
              ele1 = root-> data;
              pre = root;
          }
          Solve1(root-> right, key);
      }
      else
      Solve1(root-> left, key);
    }
    
    void Solve2(Node* root, int key){
      if(root == NULL)
      return;
      if(root-> data > key){
          if(ele2 > root -> data){
              ele2 = root -> data;
              succ = root;
          }
          Solve2(root -> left, key);
      }
      else
      Solve2(root-> right, key);
    }
  public:
    vector<Node*> findPreSuc(Node* root, int key) {
        // Q. Predecessor and Successor
        // code here
        Solve1(root, key);  
        Solve2(root, key);  
        return {pre, succ};
    }
};

