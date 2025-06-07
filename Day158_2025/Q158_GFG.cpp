class Solution {
  public:
    int longestCommonSum(vector<int> &a1, vector<int> &a2) {
        // Q. Longest Span in two Binary Arrays
        // Code here.
        int n = a1.size();
        int res = 0;
        vector<int> diff(2 * n + 1, -1);
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += a1[i];
            sum2 += a2[i];
            int currentDiff = sum1 - sum2;
            int index = currentDiff + n;
            if (currentDiff == 0) {
                res = max(res, i + 1);
            }
            else if (diff[index] != -1) {
                res = max(res, i - diff[index]);
            } 
            else {
                diff[index] = i;
            }
        }
        
        return res;
    }
};