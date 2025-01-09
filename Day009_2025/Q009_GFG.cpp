//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    vector<int> subarraySum(vector<int> &arr, int target) {
        // code here
        // Q. Indexes of Subarray Sum
        int start = 0, end = 0;
        int currSum = 0;
        
        for (int i = 0; i < arr.size(); ++i) {
            currSum += arr[i];
            if (currSum >= target) {
                end = i;
                while (currSum > target && start < end) {
                    currSum -= arr[start++];
                }
                if (currSum == target) {
                    return {start + 1, end + 1};
                }
            }
        }
        
        return {-1};
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr;
        int d;
        string input;

        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }

        cin >> d;
        cin.ignore();

        Solution ob;
        vector<int> result = ob.subarraySum(arr, d);
        for (int i : result) {
            cout << i << " ";
        }
        cout << "\n~\n";
    }
    return 0;
}

// } Driver Code Ends