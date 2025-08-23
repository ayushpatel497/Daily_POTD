class Solution {
    bool isPossible(vector<int> &arr, int k, int pageLimit) {
        int count = 1;
        int pageSum = 0;
        for(int i = 0; i < arr.size(); i++) {
            if(pageSum + arr[i] > pageLimit) {
                count++;
                pageSum = arr[i];
            }
            else {
                pageSum += arr[i];
            }
        }
        return (count <= k);
    }
  public:
    int findPages(vector<int> &arr, int k) {
        // Q. Allocate Minimum Pages
        // code here
        if(k > arr.size())
            return -1;
            
        int start = *max_element(arr.begin(), arr.end());
        int end = accumulate(arr.begin(), arr.end(), 0);
        int ans = -1;
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            
            if(isPossible(arr, k, mid)){
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        
        return ans;
    }
};