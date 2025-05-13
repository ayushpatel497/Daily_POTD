//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    int nCr(int n, int r) {
        // Q. nCr
        // code here
        if (r > n) return 0;
        if (r == 0 || n == r) return 1;
        
        double res = 0;
        for (int i = 0; i < r; i++) {
            res += log(n-i) - log(i+1);
        }
        
        return (int)round(exp(res));
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, r;
        cin >> n >> r;

        Solution ob;
        cout << ob.nCr(n, r) << endl;

        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends