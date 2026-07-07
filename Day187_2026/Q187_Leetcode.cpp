class Solution {
public:
    int removeCoveredIntervals(vector<vector<int>>& intervals) {
        // Q. Remove Covered Intervals
        ranges::sort(intervals, {}, [](auto& x) {
            return pair{x[0], -x[1]};
        });

        int res = 0, r = 0;

        for (auto& x : intervals) {
            res += x[1] > r;
            r = max(r, x[1]);
        }

        return res;
    }
};