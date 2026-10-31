class Solution {
  public:
    int maxPackages(vector<int>& arr, int totalTime) {
        // Q. Maximum Packages within Time
        // code here
        int ans = 0;
        int n = arr.size();
        int i = 0;
        int sum = 0;
        for (int j = 0; j < n; j++) {
            sum += arr[j];
            if (j - i + 1 > totalTime) {
                sum -= arr[i];
                i++;
            }
            ans = max(ans, sum);
        }

        return ans;
    }
};