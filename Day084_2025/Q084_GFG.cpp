//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

// User function Template for C++
class Solution {
    bool evaluate(bool b1, bool b2, char op) {
        if (op == '&') return b1 & b2;
        if (op == '|') return b1 | b2;
        return b1 ^ b2;
    }
    
  public:
    int countWays(string &s) {
        // Q. Boolean Parenthesization
        // code here
        int n = s.size();
        
        // dp[i][j][0] -> False count, dp[i][j][1] -> True count
        vector<vector<vector<int>>> dp(n, vector<vector<int>>(n, vector<int>(2, 0)));

        // Initialize base cases
        for (int i = 0; i < n; i += 2) {
            dp[i][i][1] = (s[i] == 'T');
            dp[i][i][0] = (s[i] == 'F');
        }

        // Iterate over increasing lengths of subexpressions
        for (int length = 2; length < n; length += 2) {
            for (int i = 0; i < n - length; i += 2) {
                int j = i + length;
                dp[i][j][0] = dp[i][j][1] = 0;

                for (int k = i + 1; k < j; k += 2) {
                    char op = s[k];

                    int leftTrue = dp[i][k - 1][1];
                    int leftFalse = dp[i][k - 1][0];
                    int rightTrue = dp[k + 1][j][1];
                    int rightFalse = dp[k + 1][j][0];

                    // True evaluations
                    if (evaluate(true, true, op)) dp[i][j][1] += leftTrue * rightTrue;
                    if (evaluate(true, false, op)) dp[i][j][1] += leftTrue * rightFalse;
                    if (evaluate(false, true, op)) dp[i][j][1] += leftFalse * rightTrue;
                    if (evaluate(false, false, op)) dp[i][j][1] += leftFalse * rightFalse;

                    // False evaluations
                    if (!evaluate(true, true, op)) dp[i][j][0] += leftTrue * rightTrue;
                    if (!evaluate(true, false, op)) dp[i][j][0] += leftTrue * rightFalse;
                    if (!evaluate(false, true, op)) dp[i][j][0] += leftFalse * rightTrue;
                    if (!evaluate(false, false, op)) dp[i][j][0] += leftFalse * rightFalse;
                }
            }
        }

        return dp[0][n - 1][1];
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        Solution ob;
        int ans = ob.countWays(s);
        cout << ans << endl;
        cout << "~" << endl;
    }
}
// } Driver Code Ends