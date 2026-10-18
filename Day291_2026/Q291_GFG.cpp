class Solution {
  public:
    int minimumStep(int n) {
        // Q. Shortest Path From 1 To n
        // code here
        int ans = 1;
        while(n && ans++) (n % 3) ? n-- : n /= 3;
        return ans - 2;
    }
};