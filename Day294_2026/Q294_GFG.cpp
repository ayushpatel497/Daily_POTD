class Solution {
  public:
    int minSubarraySum(vector<int> &arr) {
        // Q. Minimum Sum Subarray
        // code here
        int n = arr.size();
        int minEnding = arr[0];
        int minSoFar = arr[0];
        for (int i = 1; i < n; i++) {
            minEnding = min(arr[i], minEnding + arr[i]);
            minSoFar = min(minSoFar, minEnding);
        }
        return minSoFar;
    }
};