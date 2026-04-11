class Solution {
  public:
    int countIncreasing(vector<int>& arr) {
        // Q. Count increasing Subarrays
        // code here.
        int n = arr.size();
        int cnt = 0;
        int i = 0, j = 1;
        while(j < n){
            while(j < n && arr[j - 1] < arr[j]) j++;
            int t = j - i;
            cnt += (t * (t - 1)) / 2;
            i = j;
            j++;
        }
        return cnt;
    }
};
