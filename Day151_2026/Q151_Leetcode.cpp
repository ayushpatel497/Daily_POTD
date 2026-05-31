class Solution {
public:
    bool asteroidsDestroyed(int mass, vector<int>& asteroids) {
        // Q. Destroying Asteroids
        sort(asteroids.begin(), asteroids.end());
        long long mass1 = mass;
        for (const int asteroid : asteroids) {
            if (mass1 < asteroid) {
                return false;
            }
            mass1 += asteroid;
        }
        return true;
    }
};