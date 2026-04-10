class Solution {
  public:
    vector<int> find3Numbers(vector<int> &arr) {
        // Q. Sorted subsequence of size 3
        // Code here
        int n = arr.size();
        vector<int> suffMax = arr;
        for(int i = n - 2; i >= 0; i--)
            suffMax[i] = max(suffMax[i + 1], arr[i]);
        int minStart = arr[0];
        for(int i = 1; i < n - 1; i++) {
            int maxEnd = suffMax[i + 1];
            int curr = arr[i];
            if(minStart < curr && curr < maxEnd) {
                return {minStart, curr, maxEnd};
            }
            minStart = min(minStart, curr);
        }
        return {};
    }
};