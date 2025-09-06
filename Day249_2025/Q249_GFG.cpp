/*
class Node {
 public:
    int data;
    Node *next;

    Node(int x) {
        data = x;
        next = NULL;
    }
};
*/

class Solution {
  public:
    int lengthOfLoop(Node *head) {
        // Q. Find length of Loop
        // code here
        if(head == nullptr || head -> next == nullptr) return 0;
        map<Node*, int> mp;
        int i = 1;
        while(head != nullptr)
        {
           if(mp.find(head) != mp.end()) return i - mp[head];
           mp[head] = i;
           i++;
           head = head -> next;
        }
       return 0;
    }
};