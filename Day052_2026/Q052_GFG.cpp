class Solution {
  public:
    int hIndex(vector<int>& citations) {
        // Q. Find H-Index
        // code here
        int n = citations.size();
        sort(citations.begin(), citations.end());
        int l = 0, r = n, ans = -1;
        
        while(l <= r) {
            int mid = (l + r) / 2;
            if(citations[n - mid] >= mid) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return ans;
    }
};