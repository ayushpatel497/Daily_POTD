class Solution {
public:
    bool check(vector<int>& nums) {
        // Q. Check if Array Is Sorted and Rotated
        int numsSize = nums.size();
        int count = 0;
        for(int numsIndex = 0; numsIndex < nums.size(); ++numsIndex){
            if(nums[numsIndex] > nums[(numsIndex + 1) % numsSize]){
                count += 1;
            }
        }
        return count <= 1;
    }
};