class Solution {
  public:
    vector<int> countDistinct(vector<int> &arr, int k) {
        // Q. Count distinct elements in every window
        // code here
        unordered_map<int, int> um;
        vector<int> ans;
        int i;
        for(i = 0; i < k; ++i){
            um[arr[i]]++;
        }
        ans.push_back(um.size());
        
        while(i < arr.size()){
            um[arr[i]]++;
            um[arr[i - k]]--;
            if(um[arr[i - k]] == 0){
                um.erase(arr[i - k]);
            }
            ans.push_back(um.size());
            i++;
        }
        return ans;
    }
};