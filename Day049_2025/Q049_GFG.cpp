//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
    int squaredDis(vector<int>& point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    
  public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        // Q. K Closest Points to Origin
        // Your code here
        priority_queue<pair<int, vector<int>>> maxHeap;
        for (int i=0;i<points.size();i++) {
            int dist = squaredDis(points[i]);
            if (maxHeap.size() < k) {
                maxHeap.push({dist, points[i]});
            } else {
                if (dist < maxHeap.top().first) {
                    maxHeap.pop();
                    maxHeap.push({dist, points[i]});
                }
            }
        }

        vector<vector<int>> res;
        while (!maxHeap.empty()) {
            res.push_back(maxHeap.top().second);
            maxHeap.pop();
        }
    
        return res;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int k;
        cin >> k;
        int n;
        cin >> n;
        vector<vector<int>> points(n, vector<int>(2));
        for (int i = 0; i < n; i++) {
            cin >> points[i][0] >> points[i][1];
        }
        Solution ob;
        vector<vector<int>> ans = ob.kClosest(points, k);
        sort(ans.begin(), ans.end());
        for (const vector<int>& point : ans) {
            cout << point[0] << " " << point[1] << endl;
        }
        cout << "~" << endl;
    }

    return 0;
}

// } Driver Code Ends