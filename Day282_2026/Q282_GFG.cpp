class Solution {
  public:
    int minOperation(int n) {
        // Q. Minimum Operations to Reach n
        // code here
        int ops = 0;
        while (n > 0) {
            if (n % 2 == 1) n--;
            else n /= 2;
            ops++;
        }
        return ops;
    }
};