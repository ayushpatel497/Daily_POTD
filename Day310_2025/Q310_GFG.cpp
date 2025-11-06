class Solution {
  public:
    int numberOfWays(int n) {
        // Q. Ways To Tile A Floor
        // code here
        if(n == 1) return 1;
        int lastSecond = 1;
        int last = 2;
        for(int num = 3; num <= n; ++num){
            int current = lastSecond + last;
            lastSecond = last;
            last = current;
        }
        return last;
    }
};