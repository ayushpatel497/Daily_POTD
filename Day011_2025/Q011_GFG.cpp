//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int longestUniqueSubstr(string &s) {
        // code here
        // Q. Longest substring with distinct characters
        unordered_map<char, int> um;
        int maxi = INT_MIN;
        int i = 0;
        int j = 0;
        while(i < s.length()){
            um[s[i]]++;
            while(um[s[i]] > 1){
                um[s[j]]--;
                j++;
            }
            maxi = max(maxi, i - j + 1);
            i++;
        }
        return maxi;
    }
};


//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    while (t--) {

        Solution obj;
        string s;
        cin >> s;
        cout << obj.longestUniqueSubstr(s) << endl;
        cout << "~"
             << "\n";
    }

    return 0;
}

// } Driver Code Ends