class Solution {
  public:
    bool checkWithinK(vector<int>& arr, int k) {
        // Q. Any Duplicate Within K Distance
        // code here
        unordered_set<int> window;
        for (int i = 0; i < arr.size(); i++) {
            if (window.count(arr[i])) return true;
            window.insert(arr[i]);
            if (window.size() > k) {
                window.erase(arr[i - k]);
            }
        }
        return false;
    }
};