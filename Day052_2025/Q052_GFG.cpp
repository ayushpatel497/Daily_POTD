//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    bool isBalanced(string& s) {
        // Q. Parenthesis Checker
        // code here
        int i=-1;
        for(auto& ch : s){
            if(ch == '(' || ch == '{' || ch == '[')
                s[++i] = ch;
            else{
                if(i >= 0 && ((s[i] == '(' && ch == ')') || (s[i] == '{' && ch == '}') || (s[i] == '[' && ch == ']')))
                    i--;
                else
                    return false;
            }
        }
        return i == -1;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    string a;
    cin >> t;
    while (t--) {
        cin >> a;
        Solution obj;
        if (obj.isBalanced(a))
            cout << "true" << endl;
        else
            cout << "false" << endl;

        cout << "~"
             << "\n";
    }
}
// } Driver Code Ends