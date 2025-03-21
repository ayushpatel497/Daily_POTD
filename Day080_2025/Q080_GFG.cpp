//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;
typedef long long int ll;


// } Driver Code Ends

class Solution {
    int findOpti(vector<int>& arr){
        // Q. Stickler Thief
        int n = arr.size();
        int pre1 = 0, pre2 = 0;
        for(int i = 1; i < n + 1; i++){
            int loot = arr[i - 1];
            int dontloot = pre1;
            if(i >= 2) loot += pre2;
            pre2 = pre1;
            pre1 = max(loot, dontloot);
        }
        return pre1;
    }
  public:
    int findMaxSum(vector<int>& arr) {
        // code here
        return findOpti(arr);
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
        cout << ob.findMaxSum(arr) << endl;
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends