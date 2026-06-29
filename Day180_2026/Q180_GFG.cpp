class Solution {
  public:
    int maxDotProduct(vector<int>& a, vector<int>& b) {
        // Q. Max Dot Product with 0 Insertions
        // code here
        int n = a.size() , m = b.size();
        int k = n-m;
        vector<int>dp(k+1 , -1);
        dp[0]= 0;
        for(int i = 0 ;i< n ; i++){
            for(int j = k ; j>=0 ; j--){
                if(dp[j]!=-1){
                    if(j!=k){
                        dp[j+1] = max(dp[j+1] , dp[j]);
                    }
                    if(i-j < m)dp[j] += a[i] * b[i-j];
                }
            }
        }
        return dp.back();
    }
};
