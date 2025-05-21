class Solution {
  public:
    int kthSmallest(int m, int n, int k) {
        // Q. Kth Smallest Number in Multiplication Table
        // code here
        int low = 1, high = n * m;
        int ans = n * m;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;

            for (int i = 1; i <= m; ++i) {
                cnt += min(mid / i, n);
            }

            if (cnt >= k) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return ans;
    }
};
