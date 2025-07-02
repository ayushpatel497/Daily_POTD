class Solution {
  public:
    int totalElements(vector<int> &arr) {
        // Q. Longest subarray with Atmost two distinct integers
        // code here
        int n = arr.size();
        if (n <= 2) return n;
        unordered_map<int, int> mp;
        int window_start = 0;
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (mp[arr[i]]) {
                mp[arr[i]]++;
            } else {
                mp[arr[i]] = 1;
                while (mp.size() > 2) {
                    mp[arr[window_start]]--;
                    if (mp[arr[window_start]] == 0) {
                        mp.erase(arr[window_start]);
                    }
                    window_start++;
                }
            }
            res = max(res, i - window_start + 1);
        }
        return res;
    }
};