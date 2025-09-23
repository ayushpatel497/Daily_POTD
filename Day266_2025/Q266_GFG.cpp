class Solution {
  public:
    void reverseQueue(queue<int> &q) {
        // Q. Queue Reversal
        // code here
        if (q.size() == 0) return ;
        int x = q.front();
        q.pop();
        reverseQueue(q);
        q.push(x);
    }
};