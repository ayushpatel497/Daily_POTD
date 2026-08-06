class Solution {
public:
    int smallestNumber(int n, int t) {
        // Q. Smallest Divisible Digit Product I
        auto check = [&](int num) -> bool {
            int product = 1;
            while (num) {
                product *= (num % 10);
                num /= 10;
                if (!product) {
                    break;
                }
            }
            return !(product % t);
        };
        while (!check(n)) {
            n++;
        }
        return n;
    }
};