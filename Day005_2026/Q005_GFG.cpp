class Solution {
  public:
    int maxSubarraySum(vector<int>& arr, int k) {
        // Q. Max Sum Subarray of size K
        // code here
        int n = arr.size();
        long long curr_sum = 0, ans = INT_MIN;
        for(int i = 0; i < k; i++) curr_sum += arr[i];
        ans = max(ans, curr_sum);
        int j = 0;
        for(int i = k; i < n; i++)
        {
            curr_sum -= arr[j++];
            curr_sum += arr[i];
            ans = max(ans, curr_sum);
        }
        return ans;
    }
};