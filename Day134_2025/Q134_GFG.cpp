//{ Driver Code Starts
// Initial template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
    string convert(string &num) {
        int count = 0 ;
        char digit = num[0] ;
        string ans ;
        int n = num.size() ;
        
        for(int i = 0 ; i < n ; i++)
            if(digit == num[i]) ++count ;
            else {
                ans.push_back(count + '0') ; ;
                ans.push_back(digit) ;
                count = 1 ;
                digit = num[i] ;
            }
            
        ans.push_back(count + '0') ; ;
        ans.push_back(digit) ;
        return ans ;
    }
  public:
    string countAndSay(int n) {
        // Q. Look and Say Pattern
        // code here
        if(n == 1) return "1" ;
        string previous = countAndSay(n - 1) ;
        return convert(previous) ;
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        Solution obj;
        cout << obj.countAndSay(n) << endl;

        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends