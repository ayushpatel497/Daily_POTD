class Solution {
  public:
    int countSetBits(int n) {
        // Q. Count set bits
        // code here
        if(n == 0)
            return 0;
        int x = 0;
        while((1 << x) <= n) x++;
            x--;
        
        int a = x * (1 << (x - 1));
        int b = n - (1 << x) + 1;
        int c = countSetBits(n - (1 << x));
        
        return a + b + c;
    }
};
