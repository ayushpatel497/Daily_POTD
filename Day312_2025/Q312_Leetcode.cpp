class Solution {
public:
    int minimumOneBitOperations(int n) {
        // Q. Minimum One Bit Operations to Make Integers Zero
        int ans = n;
        ans ^= ans >> 16;
        ans ^= ans >> 8;
        ans ^= ans >> 4;
        ans ^= ans >> 2;
        ans ^= ans >> 1;
        return ans;
    }
};