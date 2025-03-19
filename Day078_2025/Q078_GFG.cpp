//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
    int solve(vector<int>& a, int k, int n, int i, int t, int holding, vector<vector<vector<int>>> &dp) {
        // Base case
        if (i >= n || t >= k) return 0;
        if (dp[i][t][holding] != -1) return dp[i][t][holding];
        if (holding) {
            int sell = a[i] + solve(a, k, n, i + 1, t + 1, 0, dp);
            int skip = solve(a, k, n, i + 1, t, 1, dp);
            return dp[i][t][holding] = max(sell, skip);
        } else {
            int buy = -a[i] + solve(a, k, n, i + 1, t, 1, dp);
            int skip = solve(a, k, n, i + 1, t, 0, dp);
            return dp[i][t][holding] = max(buy, skip);
        }
    }
  public:
    int maxProfit(vector<int>& prices, int k) {
        // Q. Stock Buy and Sell – Max K Transactions Allowed
        // code here
        int N = prices.size();
        vector<vector<vector<int>>> dp(N, vector<vector<int>>(k + 1, vector<int>(2, -1)));
        return solve(prices, k, N, 0, 0, 0, dp);
    }
};


//{ Driver Code Starts.

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(0);

    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        string input;
        getline(cin, input);
        istringstream iss(input);
        vector<int> arr;
        int num;

        // Read integers from the input string
        while (iss >> num) {
            arr.push_back(num);
        }
        int k;
        cin >> k;
        cin.ignore();
        Solution ob;
        cout << ob.maxProfit(arr, k) << endl;
        cout << "~" << endl;
    }
    return 0;
}
// } Driver Code Ends