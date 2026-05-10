class Solution {
  public:
    int maxProfit(int x, int y, vector<int> &a, vector<int> &b) {
        // Q. Max Profit from Two Machines
        // code here
        int n = a.size();
        vector<pair<int, pair<int, int>>> arr(n);
        for(int i = 0; i < n; i++) {
            if(a[i] > b[i]) arr[i] = {a[i] - b[i], {a[i], b[i]}};
            else arr[i] = {b[i]-a[i], {a[i], b[i]}};
        } 
        sort(arr.begin(), arr.end(), greater<pair<int, pair<int, int>>>());
        int ans = 0;
        for(int i = 0; i < n; i++) {
            pair<int, int> ele = arr[i].second;
            int diff = arr[i].first;
            bool flag = ele.first >= ele.second;
            if(!diff) {
                ans += ele.first;
                if(x >= y) x--;
                else y--;
                continue;
            }
            if((flag and x) or (!flag and !y)) {
                ans += ele.first;
                x--;
            } else {
                ans += ele.second;
                y--;
            }

        } return ans;
    }
};