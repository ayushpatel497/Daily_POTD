class Solution {
  public:
    int countConsec(int n) {
        // Q. Trail of ones
        // code here
        if (n == 1) return 0;
        long long total = 1LL << n;
        long long dp0 = 1, dp1 = 1;
        for (int i = 2; i <= n; i++) {
            long long new_dp0 = dp0 + dp1;
            long long new_dp1 = dp0;
            dp0 = new_dp0;
            dp1 = new_dp1;
        }
        long long without_consecutive = dp0 + dp1;
        return (int)(total - without_consecutive);
    }
};