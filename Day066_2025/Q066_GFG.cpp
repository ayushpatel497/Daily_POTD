//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

// User function Template for C++

class Solution {
  public:
    int longestPalinSubseq(string &s) {
        // Q. Longest Palindromic Subsequence
        // code here
        int n = s.size();
        vector<int> curr(n), prev(n);
        for (int i = n - 1; i >= 0; --i){
            curr[i] = 1;
            for (int j = i + 1; j < n; ++j){
                if (s[i] == s[j]){
                    curr[j] = prev[j - 1] + 2;
                }
                else{
                    curr[j] = max(prev[j], curr[j - 1]);
                }
            }
            prev = curr;
        }
    
        return curr[n-1];
    }
};


//{ Driver Code Starts.

int32_t main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        Solution ob;
        cout << ob.longestPalinSubseq(s) << endl;

        cout << "~"
             << "\n";
    }
}

// } Driver Code Ends