class Solution {
  public:
    int bitonic(vector<int> &arr) {
        // Q. Longest Bitonic Subarray
        // code here
        int r = 1;
        int count = 1;
        int e = 0;
        int ans = 1;
        int n = arr.size();
        for(int i = 1; i < n; i++){
            if(arr[i - 1] == arr[i]){
                count++;
                e++;
            }
            else if(arr[i] < arr[i - 1]){
                count++;
                e = 0;
                r = 0;
            }
            else{
                if(r == 0){
                    r = 1;
                    count = e + 2;
                    e = 0;
                }
                else{
                    count++;
                    e = 0;
                }
            }
            ans = max(ans, count);
        }
        
        return ans;
    }
};