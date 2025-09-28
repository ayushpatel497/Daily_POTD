class Solution {
  public:
    vector<int> longestSubarray(vector<int>& arr, int x) {
        // Q. Longest Bounded-Difference Subarray
        // code here
        priority_queue<int>maxi;
        priority_queue<int , vector<int> , greater<int>>mini;
        unordered_map<int,int>m;
        int l = 0 ;
        int in = -1;
        int start = 0 ;
        
        for(int i=0 ; i<arr.size() ; i++){
            m[arr[i]]++;
            maxi.push(arr[i]);
            mini.push(arr[i]);
            
            
            while(maxi.top() - mini.top() > x){
                m[arr[start]]--;
                while(!maxi.empty() && m[maxi.top()] == 0){
                    maxi.pop();
                }
                
                while(!mini.empty() && m[mini.top()] == 0){
                    mini.pop();
                }
                start++;
            }
            
            if(l < i - start + 1){
                in = start ;
                l = i-start+1;
            }
            
        }

        vector<int>ans;
        
        for(int i=in ; i<in+l ; i++){
            ans.push_back(arr[i]);
        }
        
        return ans;
    }
};