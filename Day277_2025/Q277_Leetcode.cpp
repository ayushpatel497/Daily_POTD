class Solution {
public:
    int maxArea(vector<int>& height) {
        // Q. Container With Most Water
        int left = 0, right = height.size() - 1, maxArea = 0;
        while(left < right){
            int b = right - left;
            int l = height[left] < height[right] ? height[left++] : height[right--];
            maxArea = max(maxArea, l * b);
        }

        return maxArea;
    }
};