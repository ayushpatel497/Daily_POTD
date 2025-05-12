//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

// User function Template for C++
class Solution {
  public:
    int mostBooked(int n, vector<vector<int>> &meetings) {
        // Q. Meeting Rooms III
        // code here
        vector<int> cnt(n, 0);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> occ;
        priority_queue<int, vector<int>, greater<int>> avail;
        for (int i = 0; i < n; ++i){
            avail.push(i);
        }
        sort(meetings.begin(), meetings.end());
    
        for (auto &m : meetings) {
            int s = m[0], e = m[1];
            while (!occ.empty() && occ.top().first <= s) {
                avail.push(occ.top().second);
                occ.pop();
            }
            if (!avail.empty()) {
                int room = avail.top();
                avail.pop();
                occ.push({e, room});
                cnt[room]++;
            }
            else {
                int endTime = occ.top().first;
                int room = occ.top().second;
                occ.pop();
                occ.push({endTime + (e - s), room});
                cnt[room]++;
            }
        }
        int maxCnt = 0, res = 0;
        for (int i = 0; i < n; ++i) {
            if (cnt[i] > maxCnt) {
                maxCnt = cnt[i];
                res = i;
            }
        }
    
        return res;
    }
};


//{ Driver Code Starts.

int main() {
    int t, n, m;
    cin >> t;
    while (t--) {
        cin >> n;
        cin >> m;
        vector<vector<int>> meetings(m, vector<int>(2));
        for (int i = 0; i < m; i++) {
            cin >> meetings[i][0] >> meetings[i][1];
        }
        Solution ob;
        cout << ob.mostBooked(n, meetings) << endl;
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends