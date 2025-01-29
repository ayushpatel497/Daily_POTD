//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    double power(double b, int e) {
        // Q. Implement Pow
        // code here
        if (e == 0){
            return 1;
        }
        
        if (e < 0){
            return 1 / power(b, -e);
        }
            
        double halfPower = power(b, e / 2);
    	
        if (e % 2 == 0){
            return halfPower * halfPower;
        }
            
        else{
            return b * halfPower * halfPower;
        }
    }
};

//{ Driver Code Starts.

int main() {
    cout << fixed << setprecision(5);
    int t;
    cin >> t;
    while (t--) {
        double b;
        cin >> b;
        int e;
        cin >> e;
        Solution ob;
        cout << ob.power(b, e) << endl;
        cout << "~" << endl;
    }

    return 0;
}
// } Driver Code Ends