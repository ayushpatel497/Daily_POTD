class Solution {
public:
    int triangleNumber(vector<int>& nums) {
        // Q. Valid Triangle Number
        int count = 0;
        if(nums.size() < 3) return count;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size() - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.size() - 1 && nums[i] != 0; j++) {
                while (k < nums.size() && nums[i] + nums[j] > nums[k])
                    k++;
                count += k - j - 1;
            }
        }
        return count;
    }
};