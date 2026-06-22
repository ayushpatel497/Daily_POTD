class Solution {
  public:
    int maxArea(vector<int> &height) {
        // Q. Maximum Area Between Bars
        // code here
        int i = 0, j = height.size() - 1, ans = 0;
        while(i < j) {
            ans = max(ans, min(height[i], height[j]) * (j - i - 1));
            if(height[i] <= height[j]) i++;
            else j--;
        }
        return ans;
    }
};