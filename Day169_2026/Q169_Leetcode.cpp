class Solution {
public:
    double angleClock(int hour, int minutes) {
        // Q. Angle Between Hands of a Clock
        double x = hour + minutes / 60.0;
        double diff = fmod(11.0 * x, 12.0);
        return min(diff, 12.0 - diff) * 30.0;
    }
};