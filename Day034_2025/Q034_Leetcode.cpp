class Solution {
public:
    int longestMonotonicSubarray(vector<int>& nums) {
        // Q. Longest Strictly Increasing or Strictly Decreasing Subarray
        int increasingLength = 1;
        int decreasingLength = 1;
        int maxLength = 1;
        for(int currentIndex = 1; currentIndex < nums.size(); ++currentIndex){
            if(nums[currentIndex] < nums[currentIndex - 1]){
                decreasingLength += 1;
                increasingLength = 1;
            }
            else if(nums[currentIndex] > nums[currentIndex - 1]){
                increasingLength += 1;
                decreasingLength = 1;
            }
            else{
                increasingLength = 1;
                decreasingLength = 1;
            }
            maxLength = max(maxLength, max(increasingLength, decreasingLength));
        }
        return maxLength;
    }
};