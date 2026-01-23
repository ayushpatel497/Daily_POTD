class Solution {
  public:
    int maxPeople(vector<int> &arr) {
        // Q. Maximum People Visible in a Line
        // code here
        int n = arr.size();
        stack<int> s;
        vector<int> ng(n, n), pg(n, -1);
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            while(!s.empty() && arr[i] >= arr[s.top()]){
                ng[s.top()] = i;
                s.pop();
            }
            s.push(i);
        }
        
        while(!s.empty()) s.pop();
        for(int i = n - 1; i >= 0; i--){
            while(!s.empty() && arr[i] >= arr[s.top()]){
                pg[s.top()] = i;
                s.pop();
            }
            s.push(i);
        }
        
        for(int i = 0; i < n; i++){
            ans = max(ans, ng[i] - pg[i] - 1);
        }
        
        return ans;
    }
};