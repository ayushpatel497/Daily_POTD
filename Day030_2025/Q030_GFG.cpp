//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
    vector<vector<int>> result;
    int row[10], k = 0;
    bool place(int r,int c) {
    	for(int prev = 0; prev < c; prev++)
    		if(row[prev] == r or abs(row[prev] - r) == abs(prev - c)) 
    			return false;
    	return true;
    }
    void getNQueenPosition(int column ,int n) {
    	if(n == 2 or n == 3)
    	    return;
    	if(column == n) {
    		vector<int> v;
    		for(int i = 0; i < n; i++)
    		    v.push_back(row[i] + 1);
    		result.push_back(v);
    		k++;
    	}
    	
    	for(int i = 0; i < n; i++) {
    		if(place(i, column)) {
    			row[column] = i;
    			getNQueenPosition(column + 1, n);
    		}
    	}
    }

  public:
    vector<vector<int>> nQueen(int n) {
        // Q. N-Queen Problem
        // code here
        int column = 0;
        getNQueenPosition(column, n);
        return result;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;

        Solution ob;
        vector<vector<int>> ans = ob.nQueen(n);
        if (ans.size() == 0)
            cout << -1 << "\n";
        else {
            sort(ans.begin(), ans.end());
            for (int i = 0; i < ans.size(); i++) {
                cout << "[";
                for (int u : ans[i])
                    cout << u << " ";
                cout << "] ";
            }
            cout << endl;
        }

        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends