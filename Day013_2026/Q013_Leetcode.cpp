class Solution {
public:
    double separateSquares(vector<vector<int>>& squares) {
        // Q. Separate Squares I
        long long total_area = 0;
        vector<tuple<int, int, int>> events;
        for (const auto& sq : squares) {
            int y = sq[1], l = sq[2];
            total_area += (long long)l * l;
            events.emplace_back(y, l, 1);
            events.emplace_back(y + l, l, -1);
        }
        sort(events.begin(), events.end(), [](const auto& a, const auto& b) {
            return get<0>(a) < get<0>(b);
        });

        double covered_width = 0;
        double curr_area = 0;
        double prev_height = 0;
        for (const auto& [y, l, delta] : events) {
            int diff = y - prev_height;
            double area = covered_width * diff;
            if (2LL * (curr_area + area) >= total_area) {
                return prev_height + (total_area - 2.0 * curr_area) / (2.0 * covered_width);
            }
            covered_width += delta * l;
            curr_area += area;
            prev_height = y;
        }

        return 0.0;
    }
};