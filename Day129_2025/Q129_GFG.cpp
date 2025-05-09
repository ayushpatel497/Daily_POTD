//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends



class Solution {
    string maxNum = "";

    void helper(string &str, int k, int idx) {
        if (k == 0) return;
        char maxDigit = str[idx];
        for (int i = idx + 1; i < str.size(); i++) {
            if (str[i] > maxDigit) maxDigit = str[i];
        }

        if (maxDigit != str[idx]) k--;

        for (int i = str.size() - 1; i >= idx; i--) {
            if (str[i] == maxDigit) {
                swap(str[i], str[idx]);
                if (str > maxNum) maxNum = str;
                helper(str, k, idx + 1);
                swap(str[i], str[idx]);
            }
        }
    }
  public:
    // Function to find the largest number after k swaps.
    string findMaximumNum(string& s, int k) {
        // Q. Largest number in K swaps
        // code here.
        maxNum = s;
        helper(s, k, 0);
        return maxNum;
    }
};


//{ Driver Code Starts.

int main() {
    int t, k;
    string str;

    cin >> t;
    while (t--) {
        cin >> k >> str;
        Solution ob;
        cout << ob.findMaximumNum(str, k) << endl;

        cout << "~"
             << "\n";
    }
    return 0;
}

// } Driver Code Ends