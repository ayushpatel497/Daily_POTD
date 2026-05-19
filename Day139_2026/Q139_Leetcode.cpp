class Solution {
    bool binarySearch(int target, vector<int>& nums) {
        int left = 0;
        int right = nums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
public:
    int getCommon(vector<int>& nums1, vector<int>& nums2) {
        // Q. Minimum Common Value
        if (nums1.size() > nums2.size()) {
            return getCommon(nums2, nums1);
        }
        for (int num : nums1) {
            if (binarySearch(num, nums2)) {
                return num;
            }
        }

        return -1;
    }
};