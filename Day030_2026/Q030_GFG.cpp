class Solution {
  public:
    void rearrangeQueue(queue<int> &q) {
        // Q. Interleave the First Half of the Queue with Second Half
        // code here
        queue<int> t1;
        int n = (q.size()) / 2;
        int nc = n; 
        while(n--){
            t1.push(q.front()); 
            q.pop();      
        }
        
        n = nc;
        while(n--){  
            q.push(t1.front()); 
            t1.pop();
            q.push(q.front()); 
            q.pop();        
        }
        
        return;
    }
};