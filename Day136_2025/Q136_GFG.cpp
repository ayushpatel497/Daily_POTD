//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

struct Node {
    int val, row, col;
    bool operator>(const Node& other) const {
        return val > other.val;
    }
};

class Solution {
  public:
    vector<int> findSmallestRange(vector<vector<int>>& arr) {
        // Q. Smallest range in K lists
        // code here
        int N = arr.size();
        int K = arr[0].size();
        priority_queue<Node, vector<Node>, greater<Node>> pq;
        int maxVal = INT_MIN;
    
        for (int i = 0; i < N; i++) {
            pq.push({arr[i][0], i, 0});
            maxVal = max(maxVal, arr[i][0]);
        }
    
        int minRange = INT_MAX, minEl, maxEl;
    
        while (true) {
            Node curr = pq.top(); pq.pop();
            int minVal = curr.val;
    
            if (maxVal - minVal < minRange) {
                minRange = maxVal - minVal;
                minEl = minVal;
                maxEl = maxVal;
            }
    
            if (curr.col + 1 == K) break;
            int nextVal = arr[curr.row][curr.col + 1];
            pq.push({nextVal, curr.row, curr.col + 1});
            maxVal = max(maxVal, nextVal);
        }
    
        return {minEl, maxEl};
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k;
        cin >> n >> k;
        vector<vector<int>> arr(k, vector<int>(n));

        for (int i = 0; i < k; i++)
            for (int j = 0; j < n; j++)
                cin >> arr[i][j];

        Solution obj;
        vector<int> range = obj.findSmallestRange(arr);
        cout << range[0] << " " << range[1] << "\n";
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends