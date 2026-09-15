/* Binary Tree Node Structure
class Node {
  public:
    int data;
    Node *left;
    Node *right;

    Node(int x) {
        data = x;
        left = nullptr;
        right = nullptr;
    }
};
*/

class Solution {
  public:
    int getCount(Node *root, int k) {
        // Q. Visit Leaves with Budget
        // code here
        queue<Node*> q;
        q.push(root);
        q.push(nullptr);
        int n = 1;
        int m = 0;
        int cnt = 0;
        while(!q.empty()){
            Node* ans = q.front();
            q.pop();
            if(ans){
                if(!ans-> left && !ans-> right){
                    m = m + n;
                    if(m <= k){
                        cnt++;
                    }
                }
                if(ans-> left){
                    q.push(ans-> left);
                }
                if(ans-> right){
                    q.push(ans-> right);
                }
            }
            else{
                n++;
                if(!q.empty()){
                   q.push(nullptr);
                }
            }
        }
        return cnt;
    }
};