//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int maxWater(vector<int> &arr) {
        // code here
        // Q. Trapping Rain Water
        int left = 0;
        int right = arr.size() - 1;
        int level = -1;
        int water = 0;
        while(left < right){
            int lower;
            lower = arr[left] < arr[right] ? arr[left++] : arr[right--];
            level = max(level, lower);
            water += level - lower;
        }
        return water;
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
        int res = ob.maxWater(arr);

        cout << res << endl << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends