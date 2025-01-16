class Solution {
public:
    int xorAllNums(vector<int>& nums1, vector<int>& nums2) {
        // Q. Bitwise XOR of All Pairings
        int nums1Size = nums1.size();
        int nums2Size = nums2.size();
        int xorAll = 0;
        if(nums1Size & 1){
            for(int index = 0; index < nums2Size; ++index){
                xorAll ^= nums2[index];
            }
        }
        if(nums2Size & 1){
            for(int index = 0; index < nums1Size; ++index){
                xorAll ^= nums1[index];
            }
        }
        return xorAll;
    }
};