//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    int maxLength(string& str) {
        // Q. Longest valid Parentheses
        // code here
        int n = str.size();
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < n; i++) {
            if (str[i] == '(')
                left++;
            else
                right++;
            if (left == right)
                maxlength = max(maxlength, 2 * right);
            else if (right > left)
                left = right = 0;
        }
    
        left = right = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (str[i] == '(')
                left++;
            else
                right++;
            if (left == right)
                maxlength = max(maxlength, 2 * left);
            else if (left > right)
                left = right = 0;
        }
        return maxlength;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        string S;
        cin >> S;

        Solution ob;
        cout << ob.maxLength(S) << "\n";

        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends