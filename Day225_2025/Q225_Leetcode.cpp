class Solution {
public:
    bool isPowerOfThree(int n) {
        // Q. Power of Three
        if(n==0){
            return false;
        }
        while(n%3 == 0){
            n /= 3;
        }
        return n==1;  
    }
};