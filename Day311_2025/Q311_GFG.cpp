class Solution {
    static bool comp(vector<int>& a, vector<int>& b){
        return a[1] < b[1];
    }
  public:
    int maxProfit(vector<vector<int>> &jobs) {
        // Q. Weighted Job Scheduling
        // code here
        int size = jobs.size();
        sort(jobs.begin(), jobs.end(), comp);
        vector<int> endTimes(size);
        
        for(int index = 0; index < size; ++index){
            endTimes[index] = jobs[index][1];
        }
        
        vector<long long> dp(size);
        dp[0] = jobs[0][2];
        
        for(int index = 1; index < size; ++index){
            long long profitInclude = jobs[index][2];
            int idx = upper_bound(endTimes.begin(), endTimes.end(), jobs[index][0]) - endTimes.begin() - 1;
            if(idx >= 0){
                profitInclude += dp[idx];
            }
            long long profitExclude = dp[index - 1];
            dp[index] = max(profitInclude, profitExclude);
        }
        
        return dp[size - 1];
    }
};
