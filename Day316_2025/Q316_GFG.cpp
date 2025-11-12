class Solution {
    int solve(string &s, string &p, int i, int j, vector<vector<int>> &dp){
        if(i == s.size() && j == p.size()){
            return 1;
        }
        if(j == p.size()){
            return 0;
        }
        if(i == s.size()){
            while(j < p.size()){
                if(p[j] != '*'){
                    return 0;
                }
                j++;
            }
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        else{
            if(p[j] == '?'){
                return dp[i][j] = solve(s, p, i + 1, j + 1, dp);
            }
            if(p[j] == '*'){
                bool a = solve(s, p, i + 1, j + 1, dp);
                bool b = solve(s, p, i, j + 1, dp);
                bool c = solve(s, p, i + 1, j, dp);
                return dp[i][j] = a | b | c;
            }
            if(s[i] != p[j]){
                return dp[i][j] = 0;
            }
            else{
                return dp[i][j] = solve(s, p, i + 1, j + 1, dp);
            }
        }
    }
  public:
    bool wildCard(string &txt, string &pat) {
        // Q. Wildcard Pattern Matching
        // code here
        int n = txt.size();
        int m = pat.size();
        vector<vector<int>> dp(n + 1, vector<int> (m + 1, -1));
        return solve(txt, pat, 0, 0, dp);
    }
};