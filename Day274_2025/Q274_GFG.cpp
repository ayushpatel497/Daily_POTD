class Solution {
    void helper(vector<int> arr,vector<int>temp,vector<vector<int>> &ans, int idx, map<vector<int>,int>&hash){
        if(temp.size() == arr.size()){
            if(hash.find(temp) == hash.end()){
                ans.push_back(temp);
                hash[temp] = 1;
            }
            return;
        }
        else{
            for(int i = idx; i < arr.size(); i++){
                temp.push_back(arr[i]);
                swap(arr[idx], arr[i]);
                helper(arr, temp, ans, idx + 1, hash);
                temp.pop_back();
                swap(arr[i], arr[idx]);
            }
        }
    }
  public:
    vector<vector<int>> uniquePerms(vector<int>& arr) {
        // code here
        vector<vector<int>> ans;
        vector<int> temp;
        map<vector<int>, int> hash;
        helper(arr, temp, ans, 0, hash);
        sort(begin(ans), end(ans));
        return ans;
    }
};