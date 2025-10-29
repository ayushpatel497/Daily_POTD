class Solution {
    void dfs(int idx, int dist, vector<vector<int>> &adj, vector<bool> &visited, int &maxDist, int &farthestNode){
        visited[idx] = true;
        if(dist>maxDist){
            maxDist = dist;
            farthestNode = idx;
        }
        
        for(int u : adj[idx]){
            if(!visited[u]){
                dfs(u, dist+1, adj, visited, maxDist, farthestNode);
            }
        }
    
    }
  public:
    int diameter(int V, vector<vector<int>>& edges) {
        // Q. Graph Diameter
        // Code here
        vector<vector<int>> adj(V);
        vector<bool> visited(V, false);
        
        for(auto e : edges){
            int u= e[0];
            int v= e[1];
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        
        int maxDist = 0;
        int farthestNode = 0;
        dfs(0, 0, adj, visited, maxDist, farthestNode);
        fill(visited.begin(), visited.end(), false);
        dfs(farthestNode, 0, adj, visited, maxDist, farthestNode);
        
        return maxDist;
    }
};
