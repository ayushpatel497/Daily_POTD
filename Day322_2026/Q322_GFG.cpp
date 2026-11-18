class Solution {
  public:
    int findXOR(int l, int r) {
        // Q. XOR of Number Range
        // code here
        auto xorUpto = [](int n) {
            if (n % 4 == 0) return n;
            if (n % 4 == 1) return 1;
            if (n % 4 == 2) return n + 1;
            return 0;
        };
        return xorUpto(r) ^ xorUpto(l - 1);
    }
};