class Solution {
  public:
    bool isBitSet(int n) {
        // Q. Check if All Bits Set
        // code here
        int x = __builtin_popcount(n);
        int y = log2(n) + 1;
        return x == y;
    }
};