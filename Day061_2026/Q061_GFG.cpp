class Solution {
  public:
    int maxWater(vector<int> &arr) {
        // Q. Trapping Rain Water
        // code here
        int left = 0;
        int right = arr.size() - 1;
        int level = -1;
        int water = 0;
        while(left < right){
            int lower;
            lower = arr[left] < arr[right] ? arr[left++] : arr[right--];
            level = max(level, lower);
            water += level - lower;
        }
        return water;
    }
};