class Solution {
  public:
    bool canFinish(int n, vector<vector<int>>& prerequisites) {
        // Q. Course Schedule I
        // Code here
        vector<int> adj[n];
        vector<int> ind(n, 0);
        for(auto &it: prerequisites){
            int u = it[0];
            int v = it[1];
            adj[v].push_back(u);
            ind[u]++;
        }
        
        queue<int>q;
        for(int i = 0; i < n; i++){
            if(ind[i] == 0) q.push(i);
        }
        
        vector<int>tmp;
        while(!q.empty()){
            int node = q.front();
            q.pop();
            tmp.push_back(node);
            for(auto &ngbr: adj[node]){
                ind[ngbr]--;
                if(ind[ngbr] == 0) q.push(ngbr);
            }
        }
        
        return tmp.size() == n ? true : false;
    }
};