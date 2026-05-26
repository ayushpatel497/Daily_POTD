class Solution {
  public:
    int minToggle(vector<int>& arr) {
        // Q. Minimum Toggle to Partition
        // code here
        int n = arr.size();
        int one[n];
        int zero[n];
        int y = 0;
        int x = 0;
        for(int i = 0; i < n; i++){
            one[i] = y;
            if(arr[i] == 1){
                y++;
            }
        }
         for(int i = n - 1; i >= 0; i--){
            zero[i] = x;
            if(arr[i] == 0){
                x++;
            }
        }
        int  mini = INT_MAX;
        for(int i = 0; i < n; i++){
            mini = min(zero[i] + one[i], mini);
        }
        return mini;
    }
};