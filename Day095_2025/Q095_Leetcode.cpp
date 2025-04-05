class Solution {
    public:
        int subsetXORSum(vector<int>& nums) {
            // Q. Sum of All Subset XOR Totals
            int result = 0;
            for (int num : nums) {
                result |= num;
            }
            return result << (nums.size() - 1);
        }
    };