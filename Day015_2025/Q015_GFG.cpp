//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int longestSubarray(vector<int>& arr, int k) {
        // Q. Longest Subarray with Sum K
        // code here
        unordered_map<int, int> um;
        um[0] = -1;
        int ans = 0;
        int preSum = 0;
    
        for (int i = 0; i < arr.size(); ++i) {
            preSum += arr[i];
            
            if (um.count(preSum - k))
                ans = max(ans, i - um[preSum - k]);
                
          	if (!um.count(preSum))
                um[preSum] = i;
        }
    
        return ans;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore(); // Ignore newline character after t

    while (t--) {
        vector<int> arr;
        int k;
        string inputLine;

        getline(cin, inputLine); // Read the array input as a line
        stringstream ss(inputLine);
        int value;
        while (ss >> value) {
            arr.push_back(value);
        }

        cin >> k;
        cin.ignore(); // Ignore newline character after k input

        Solution solution;
        cout << solution.longestSubarray(arr, k) << "\n";
        cout << "~\n";
    }

    return 0;
}

// } Driver Code Ends