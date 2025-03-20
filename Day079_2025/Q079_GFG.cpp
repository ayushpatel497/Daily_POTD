//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    int maxProfit(vector<int> &prices) {
        // Q. Stock Buy and Sell – Max 2 Transactions Allowed
        // code here
        int buy1 = INT_MAX, buy2 = INT_MAX, 
        profit1 = 0, profit2 = 0;
        for(int i : prices){
            buy1 = min(buy1, i);
            profit1 = max(profit1, i - buy1);
            buy2 = min(buy2, i - profit1);
            profit2 = max(profit2, i - buy2);
        }
        return profit2;
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr;
        string input;

        // Read first array
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }

        Solution ob;
        int res = ob.maxProfit(arr);

        cout << res << endl << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends