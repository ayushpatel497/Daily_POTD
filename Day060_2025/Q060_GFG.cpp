//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
    int i = 0;
  public:
    string decodedString(string &s) {
        // Q. Decode the string
        // code here
        string ans = "";
        int curr = 0;
        while (i < s.size()) {
            if (isdigit(s[i])) {  
                curr = curr * 10 + (s[i] - '0');
            } 
            else if (s[i] == '[') {  
                i++;  
                string nested = decodedString(s);  
                while (curr--) ans += nested;  
                curr = 0;  
            } 
            else if (s[i] == ']') {  
                return ans;  
            } 
            else {  
                ans += s[i];  
            }
            i++;  
        }
        
        return ans;
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
        cout << ob.decodedString(s) << "\n";

        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends