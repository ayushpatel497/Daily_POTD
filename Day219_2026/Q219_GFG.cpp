class Solution {
  public:
    int countFriendsPairings(int n) {
        // Q. Friends Pairing Problem
        // code here
        const int MOD = 1000000007;
        if (n == 1) return 1;
        if (n == 2) return 2;
        long long prev2 = 1;
        long long prev1 = 2;
        for (int i = 3; i <= n; i++) {
            long long curr = (prev1 + ((i - 1) * prev2) % MOD) % MOD;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
};
