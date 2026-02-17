class Solution {
  public:
    int overlapInt(vector<vector<int>> &arr) {
        // Q. Maximum number of overlapping Intervals
        // code here
        int maxEnd = 0;
        for (auto &interval : arr) {
            maxEnd = max(maxEnd, interval[1]);
        }
        
        vector<int> diff(maxEnd + 2, 0);
        
        for (auto &interval : arr) {
            int start = interval[0];
            int end = interval[1];
            
            diff[start] += 1;
            diff[end + 1] -= 1;
        }
        
        int current = 0;
        int maxOverlap = 0;
        
        for (int i = 0; i <= maxEnd; i++) {
            current += diff[i];
            maxOverlap = max(maxOverlap, current);
        }
        
        return maxOverlap;
    }
};
