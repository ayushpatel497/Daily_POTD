class Solution {
  public:
    int largestArea(int n, int m, int k, vector<vector<int>> &enemy) {
        // Q. Largest Unblocked Submatrix
        // code here
        if(k==0) return m*n;
        vector<int> row(n,1),col(m,1);
        for(auto it:enemy){
            row[it[0]-1]=0;
            col[it[1]-1]=0;
        }
        int countr=0,maxr=0;
        for(auto it:row){
            if(it==1){
                countr++;
                maxr=max(countr,maxr);
            }
            else countr=0;
        }
        int ans=maxr;
         countr=0,maxr=0;
         for(auto it:col){
            if(it==1){
                countr++;
                maxr=max(countr,maxr);
            }
            else countr=0;
        }
        ans=ans*maxr;
        return ans;
    }
};