class Solution {
public:
    int minPartitions(string n) {
        // Q. Partitioning Into Minimum Number Of Deci-Binary Numbers
        int ans = 0;
        for (char& c : n) ans = max(ans, c - '0');
        return ans;
    }
};