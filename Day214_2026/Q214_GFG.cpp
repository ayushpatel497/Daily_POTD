#define lli long long int
#define vvi vector<vector<lli>>
#define vi  vector<lli>
#define mod 1000000007
class Solution{
   long long recFunc(int n, int m, int r, vvi &dp){
       if(n == 0) return 1;
       if(dp[n][m] != -1) return dp[n][r];
       long long sum = 0;
       for(int i = 1; i <= m; i++){
           if(r % i == 0 || i % r == 0) {
               sum += recFunc(n - 1, m, i, dp);
               sum %= mod;
           }
       }
       dp[n][r] = sum;
       return dp[n][r];
   }
public:
    int count(int n, int m) {
        // Q. Sequences where Adjacent Divide
        // code here
        vvi dp(n + 1, vi(m + 1, -1));
        return recFunc(n, m, 1, dp);
    }
};