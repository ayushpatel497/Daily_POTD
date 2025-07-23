class Solution {
  public:
    int subarraySum(vector<int>& arr) {
        // Q. Sum of Subarrays
        // code here
        int n=arr.size();
        int sum=0;
        
        for(int i=0; i<n; i++){
            int start=i+1;
            int end=n-i;
            int contri=start*end;
            sum+=(arr[i]*contri);
        }
        
        return sum;
    }
};