class Solution {
    bool isOdd(int numberOne){
        return numberOne & 1;
    }
public:
    bool isArraySpecial(vector<int>& nums) {
        // Q. Special Array I
        int numsSize = nums.size();
        if(numsSize == 1){
            return true;
        }
        for(int numsIndex = 1; numsIndex < numsSize; ++numsIndex){
            if((isOdd(nums[numsIndex]) && isOdd(nums[numsIndex - 1])) ||
            (!isOdd(nums[numsIndex]) && !isOdd(nums[numsIndex - 1]))){
                return false;
            }
        }
        return true;
    }
};