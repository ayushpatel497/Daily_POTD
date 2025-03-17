//{ Driver Code Starts

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    bool isSubsetSum(vector<int>& arr, int sum) {
        // Q. Subset Sum Problem
        // code here
        int n = arr.size();
        vector<bool> prev(sum + 1, false), curr(sum + 1);
        prev[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j < arr[i - 1])
                    curr[j] = prev[j];
                else
                    curr[j] = (prev[j] || prev[j - arr[i - 1]]);
            }
            prev = curr;
        }
        
        return prev[sum];
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
        int sum;
        cin >> sum;
        cin.ignore();

        Solution ob;
        if (ob.isSubsetSum(arr, sum))
            cout << "true" << endl;
        else
            cout << "false" << endl;
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends