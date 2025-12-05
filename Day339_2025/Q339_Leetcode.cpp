class Solution {
public:
    int countPartitions(vector<int>& nums) {
        // Q. Count Partitions with Even Sum Difference.
        int totalSum = 0;
        for (int x : nums) {
            totalSum += x;
        }
        return totalSum % 2 == 0 ? nums.size() - 1 : 0;
    }
};
