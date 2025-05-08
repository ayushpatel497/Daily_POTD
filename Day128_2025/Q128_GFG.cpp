//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

// User function template for C++

class Solution {
  public:
    int findMissing(vector<int> &arr) {
        // Q. Missing element of AP
        // code here
        int n=arr.size();
        int d=INT_MAX;
        
        for(int i=1;i<n;i++) d=min(d,arr[i]-arr[i-1]);
        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1]!=d) return arr[i]-d;
        }
        
        return arr[n-1]+d;
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
        cout << ob.findMissing(arr) << "\n";
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends