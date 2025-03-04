class Solution {
    public:
        bool checkPowersOfThree(int n) {
            // Q. Check if Number is a Sum of Powers of Three
            while (n > 0) {
                if (n % 3 == 2) 
                    return false;
                n /= 3;
            }
            return true;
        }
    };