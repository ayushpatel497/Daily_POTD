class Solution {
    void solve(int n , string curr, vector<string> &res){
        if(n == 0){
            res.push_back(curr);
            return;
        }
        solve(n - 1, curr + '0', res);
        solve(n - 1, curr + '1', res);
    }
  public:
    vector<string> binstr(int n) {
        // Q. Generate all binary strings
        // code here
        vector<string> res;
        solve(n, "", res);
        return res;
    }
};