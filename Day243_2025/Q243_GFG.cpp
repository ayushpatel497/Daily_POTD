class Solution {
  public:
    int maxWater(vector<int> &arr) {
        // Q. Container With Most Water
        // code here
        int left = 0;
        int right = arr.size() - 1;
        int ans = 0;
        while(left < right){
            int tempwater = min(arr[left], arr[right]) * (right - left);
            ans = max(ans, tempwater);
            if(arr[left] < arr[right]) left++;
            else{
                right--;
            }
        }
        return ans;
    }
};