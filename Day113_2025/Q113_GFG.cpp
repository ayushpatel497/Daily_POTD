//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    vector<int> singleNum(vector<int>& arr) {
        // Q. Unique Number II
        // Code here.
        int xor_all = 0;
        for (int num : arr) {
            xor_all ^= num;   
        }
    
        int mask = xor_all & -xor_all;
        int a = 0, b = 0;
    
        for (int num : arr) {
            if (num & mask) a ^= num;
            else b ^= num;
        }
    
        if (a > b) swap(a, b);
        return {a, b};
    }
};


//{ Driver Code Starts.
int main() {
    string ts;
    getline(cin, ts);
    int t = stoi(ts);
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
        vector<int> ans = ob.singleNum(arr);
        for (auto it : ans) {
            cout << it << " ";
        }
        cout << endl;
        cout << "~" << endl;
    }
    return 0;
}
// } Driver Code Ends