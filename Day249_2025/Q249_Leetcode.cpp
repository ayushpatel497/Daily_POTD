class Solution {
    using ll = long long;
    ll get(int num) {
        int i = 1;
        int base = 1;
        ll cnt = 0;
        while (base <= num) {
            cnt += 1ll * (i + 1) / 2 * (min(base * 2 - 1, num) - base + 1);
            i++;
            base *= 2;
        }
        return cnt;
    }
public:
    long long minOperations(vector<vector<int>>& queries) {
        // Q. Minimum Operations to Make Array Elements Zero
        ll res = 0;
        for (auto& q : queries) {
            res += (get(q[1]) - get(q[0] - 1) + 1) / 2;
        }
        return res;
    }
};