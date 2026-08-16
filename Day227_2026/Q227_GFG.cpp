class Solution {
    int memo[20][2][2];
    std::string digits;
    int target_d;

    int solve(int pos, bool tight, bool started) {
        if (pos == digits.length()) {
            return started ? 1 : 0;
        }

        if (memo[pos][tight][started] != -1) {
            return memo[pos][tight][started];
        }

        int limit = tight ? (digits[pos] - '0') : 9;
        int ans = 0;

        for (int digit = 0; digit <= limit; ++digit) {
            bool new_tight = tight && (digit == limit);
            if (!started && digit == 0) {
                ans += solve(pos + 1, new_tight, false);
            } else if (digit != target_d) {
                ans += solve(pos + 1, new_tight, true);
            }
        }

        return memo[pos][tight][started] = ans;
    }
  public:
    int countWithout(int n, int d) {
        // Q. Numbers Without d as Digit
        // code here
        if (n == 0) return 0;
        digits = std::to_string(n);
        target_d = d;
        std::memset(memo, -1, sizeof(memo));

        return solve(0, true, false);
    }
};