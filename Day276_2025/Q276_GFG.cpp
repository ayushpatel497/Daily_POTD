class Solution {
    void solve(int i, int n, vector<int>&arr, vector<string>&f, string tmp, vector<string>&ans){
        if(i >= n){
            ans.push_back(tmp);
            return;
        }
        if(arr[i] == 0 || arr[i] == 1){
            solve(i + 1, n, arr, f, tmp, ans);
        } else{
            for(char &ch : f[arr[i]]){
                tmp.push_back(ch);
                solve(i + 1, n, arr, f, tmp, ans);
                tmp.pop_back();
            }
        }
    }
  public:
    vector<string> possibleWords(vector<int> &arr) {
        // Q. Possible Words From Phone Digits
        // code here
        vector<string> f = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        string tmp = ""; 
        vector<string> ans;
        solve(0, arr.size(), arr, f, tmp, ans);
        return ans;
    }
};