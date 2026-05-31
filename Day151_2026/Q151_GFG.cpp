class Solution {
  public:
    bool isSumOfConsecutive(int n) {
        // Q. Express as Consecutive Number Sum
        // code here
        return (n & (n - 1));
    }
};