class Solution {
public:
    int maxAscendingSum(vector<int>& nums) {
        // Q. Maximum Ascending Subarray Sum
        int maximumAscendingSum = nums[0];
        int currentAscendingSum = nums[0];
        for(int index = 1; index < nums.size(); ++index){
            if(nums[index] > nums[index - 1]){
                currentAscendingSum += nums[index];
            }
            else{
                maximumAscendingSum = max(maximumAscendingSum, currentAscendingSum);
                currentAscendingSum = nums[index];
            }
        }
        maximumAscendingSum = max(maximumAscendingSum, currentAscendingSum);

        return maximumAscendingSum;
    }
};