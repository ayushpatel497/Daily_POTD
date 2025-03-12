class Solution {
    public:
        int maximumCount(vector<int>& nums) {
            // Q. Maximum Count of Positive Integer and Negative Integer
            int posCount = 0;
            int negCount = 0;
    
            int left = 0;
            int right = nums.size() - 1;
    
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums[mid] >= 0){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                    negCount = mid + 1;
                }
            }
    
            left = 0;
            right = nums.size() - 1;
    
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums[mid] <= 0){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                    posCount = nums.size() - mid;
                }
            }
    
            return max(posCount, negCount);
        }
    };