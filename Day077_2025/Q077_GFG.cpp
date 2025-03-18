//{ Driver Code Starts

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    bool fun(int pos, int n, int sum, vector<int>& arr, vector<vector<bool>>& memo) 
    {
        if (sum < 0) 
            return false;
        if (pos == n) 
            return sum == 0;
        if (memo[pos][sum]) 
            return true;
        return memo[pos][sum] = fun(pos + 1, n, sum - arr[pos], arr, memo) || fun(pos + 1, n, sum, arr, memo);
    }

    int equalPartition(vector<int>& arr)
    {
        // Q. Partition Equal Subset Sum
        // code here
        int N = arr.size();
        int totalSum = 0;
        for (int i = 0; i < N; i++) 
            totalSum += arr[i];
        if (totalSum % 2 != 0) 
            return 0;
        int targetSum = totalSum / 2;
        vector<vector<bool>> memo(N + 1, vector<bool>(targetSum + 1, false));
        return fun(0, N, targetSum, arr, memo) ? 1 : 0;
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
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }

        Solution ob;
        if (ob.equalPartition(arr))
            cout << "true\n";
        else
            cout << "false\n";
        cout << "~" << endl;
    }
    return 0;
}
// } Driver Code Ends