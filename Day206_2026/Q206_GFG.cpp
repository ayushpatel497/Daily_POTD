class Solution {
  public:
    int maximumSum(vector<vector<int>>& mat, int k) {
        // Q. Max Sum Square Sub-Matrix of Size k
        // code here
        int n=mat.size();
        vector<vector<int>>pref(n, vector<int>(n, 0));
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                pref[i][j]=mat[i][j]
                            +((i>0)?pref[i-1][j]:0)
                            +((j>0)?pref[i][j-1]:0)
                            -((i>0 && j>0)?pref[i-1][j-1]:0);
            }
        }
        
        int maxi=-1e9;
        
        for(int i=0; i+k-1<n; i++){
            for(int j=0; j+k-1<n; j++){
                int p=i+k-1;
                int q=j+k-1;
                
                int sum=pref[p][q]
                        -((i>0)?pref[i-1][q]:0)
                        -((j>0)?pref[p][j-1]:0)
                        +((i>0 && j>0)?pref[i-1][j-1]:0);
                maxi=max(maxi, sum);
            }
        }
        
        return maxi;
    }
};