class Solution {
public:
    int furthestDistanceFromOrigin(string moves) {
        // Q. Furthest Point From Origin
        int L = 0, R = 0, B = 0;
        for (auto c : moves) {
            if (c == 'L') {
                L++;
            } else if (c == 'R') {
                R++;
            } else {
                B++;
            }
        }
        return abs(L - R) + B;
    }
};