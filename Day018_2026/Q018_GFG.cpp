class Solution {
  public:
    vector<int> nextFreqGreater(vector<int>& arr) {
        // Q. Next element with greater frequency
        // code here
        unordered_map<int,int>m;
        stack<int>s;
        vector<int>ans(arr.size(),-1);
        
        for(int i=0;i<arr.size();i++){
            m[arr[i]]++;
        }
        
        for(int i=0;i<arr.size();i++){
            
            while(!s.empty() && m[arr[s.top()]] < m[arr[i]]){
                ans[s.top()] = arr[i];
                s.pop();
            }
            s.push(i);
            
        }
        return ans;
    }
};
