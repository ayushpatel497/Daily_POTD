class Solution {
    bool isValid(vector<int> &arr, int k, int median) {
        int n = arr.size();
        int j = n / 2;
        int med = -1;
        for(int i = n - 1; i >= 0; --i) {
            int diff = max(0, min(median - arr[i], k));
            
            if(i == j) med = arr[i] + diff;
            if(i == j - 1 && n % 2 == 0) {
                int temp = arr[i] + diff;
                med = (med + temp) >> 1;
            }
            
            k -= diff; 
        }
        return med >= median;
    }
  public:
    int maximizeMedian(vector<int>& arr, int k) {
        // Q. Maximize median after doing k addition operation
        // code here
        int n = arr.size();
        sort(arr.begin(), arr.end());
        
        int left = 0;
        int right = INT_MAX;
        int maxMedian = left;
        
        while(left <= right) {
            int mid = right - ((right - left) >> 1);
            if(isValid(arr, k, mid)) left = mid + 1, maxMedian = mid;
            else right = mid - 1;
        }
        
        return maxMedian;
    }
};