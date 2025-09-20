class Solution {
    int f(int st,int e,vector<int>&arr){
        int ans=0;
        for(int i=st;i<=e;i++){
            if(arr[i]>e-st+1){
                return max(f(st,i-1,arr),f(i+1,e,arr));
            }
        }
        return e-st+1;
    }
  public:
    int longestSubarray(vector<int>& arr) {
        // Q. Longest Subarray Length
        // code here
        int n = arr.size();
        return f(0, n - 1, arr);
    }
};