class Solution {
public:
    bool canAliceWin(int n) {
        // Q. Stone Removal Game
        int k = (21 - sqrt(441 - 8 * n)) / 2;
        return k % 2 == 1;
    }
};