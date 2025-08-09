class Solution {
public:
    bool isPowerOfTwo(int n) {
        // Q. Power of Two
        if(n == 0) 
            return false;
        while(n % 2 == 0)
            n >>= 1;
        return n == 1;
    }
};