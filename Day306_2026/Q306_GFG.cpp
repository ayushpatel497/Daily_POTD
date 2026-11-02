class Solution {
  public:
    int largestSumCycle(vector<int>& edge) {
        // Q. Largest Sum Cycle
        // code here
        int n = edge.size();
        vector<int> visited(n, 0);
        int ans = -1;
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            vector<int> path_visited(n, 0);
            vector<int> pre_sum(n, 0);
            int idx = i;
            int sum = 0;
            while(edge[idx] != -1 && !visited[idx]){
                visited[idx] = 1;
                path_visited[idx] = 1;
                pre_sum[idx] = sum;
                sum += idx;
                idx = edge[idx];
            }
            if(edge[idx] != -1 && path_visited[idx]){
                ans = max(ans, sum - pre_sum[idx]);
            }
        }
        return ans;
    }
};