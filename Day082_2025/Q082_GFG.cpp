//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
    int mod = 1e9+7;
    int func(string &str,int n,vector<int>&dp){
        if(n == 0 || n == 1) return 1;
        if(dp[n] != -1) return dp[n]; 
        int cnt = 0;
        if(str[n-1] >= '1') cnt = cnt + func(str, n-1, dp) % mod;
        if(str[n-2] =='1' || str[n-2] == '2' && str[n-1] <='6') cnt = (cnt + func(str, n-2, dp) % mod)%mod;
        
        return dp[n] = cnt % mod;
    }
  public:
    int countWays(string &digits) {
        // Q. Total Decoding Messages
        // Code here
        int n = digits.length();
	    if(digits[0] == '0') return 0;
	    vector<int> dp(n + 1, -1);
	    
	    return func(digits, n, dp);
    }
};


//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    cin.ignore();
    while (tc--) {
        string digits;
        getline(cin, digits);
        Solution obj;
        int ans = obj.countWays(digits);
        cout << ans << "\n";

        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends