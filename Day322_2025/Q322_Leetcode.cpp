class Solution {
public:
    bool isOneBitCharacter(vector<int>& bits) {
        // Q. 1-bit and 2-bit Characters
        int i = 0;
        while (i < bits.size() - 1) {
            i += bits[i] + 1;
        }
        return i == bits.size() - 1;
    }
};