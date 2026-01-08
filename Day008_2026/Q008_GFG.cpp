class Solution {
  public:
    int countSubarrays(vector<int>& arr, int k) {
        // Q. Count Subarray with k odds
        // code here
        int n = arr.size() , ans = 0 , prev = -1;
        int curr = 0 , i = -1;
        for(int j = 0; j < n; j++){
            if(arr[j] & 1){
                curr++;
                if(i == -1)
                    i = j;
            }
            if(curr > k){
                curr--;
                prev = i;
                i++;
                while(i < n && (arr[i] & 1) != 1)
                    i++;
            }
            if(curr == k)
                ans += (i - prev);
        }
        return ans;
    }
};