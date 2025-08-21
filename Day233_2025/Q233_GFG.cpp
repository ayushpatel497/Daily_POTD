class Solution {
    bool isPossible(vector<int>& arr, int gap, int k){
        int count = 1;
        int prev = arr[0];
        for(int i = 1; i < arr.size(); i++)
        {
            if( arr[i] - prev >= gap)
            {
                count++;
                prev = arr[i];
            }
            if(count == k)
                return true;
        }
        return false;
    }
  public:
    int maxMinDiff(vector<int>& arr, int k) {
        // Q. Maximize the minimum difference between k elements
        // code here
        int n = arr.size();
        sort(arr.begin(),arr.end());
        int low  = 0;
        int high = arr[n-1] - arr[0];
        int ans = 0;
        while(low <= high)
        {
            int mid = (low + high)/2;
            if(isPossible(arr,mid,k))
            {
                ans = mid;
                low = mid + 1;
            }
            else
            {
                high = mid-1;
            }
        }
        return ans;
    }
};
