class Solution {
public:
    int smallestIndex(vector<int>& nums) {
        // Q. Smallest Index With Digit Sum Equal to Index
        auto getDigitSum = [](int num) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            return sum;
        };
        for (int i = 0; i < nums.size(); ++i) {
            if (getDigitSum(nums[i]) == i) {
                return i;
            }
        }
        return -1;
    }
};