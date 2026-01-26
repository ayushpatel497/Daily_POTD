class Solution {
  public:
    vector<vector<int>> permuteDist(vector<int>& arr) {
        // Q. Generate Permutations of an array
        // code here
        vector<vector<int>> ans;
        sort(arr.begin(), arr.end());
        do{
            ans.push_back(arr);
        }while(next_permutation(arr.begin(), arr.end()));
  
        return ans;
    }
};