class Solution {
  public:
    int countSubs(string& str) {
        // Q. Count of distinct substrings
        // code here
        int n=str.length();
        vector<int>dp(n+1,0);
        for(int i=1;i<=n;i++){
            for(int j=i-1;j>=1;j--){
                int cnt=0;
                int t=i;
                while(j>=1 && str[t-1]==str[j-1]){
                    cnt++;
                    t--;
                    j--;
                }
                if(cnt){
                    j++;
                }
                dp[i]=max(dp[i],cnt);
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            ans+=i-dp[i];
        }
        return ans;
    }
};