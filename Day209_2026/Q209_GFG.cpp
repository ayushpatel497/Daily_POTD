class Solution {
  public:
    int shortestPath(int V, int src, int dest, vector<vector<int>> &edges) {
        // Q. Shortest Path in 1-2 Graph
        // code here
        vector<vector<pair<int, long long int>>> adj(V);
        vector<long long int> dist(V, 1LL * INT_MAX);
        dist[src] = 0LL;
        
        for(auto v: edges){
            adj[v[0]].push_back({v[1], 1LL * v[2]});  
            adj[v[1]].push_back({v[0], 1LL * v[2]});  
        }
        
        queue<pair<int, long long int>> q;
        q.push({src, dist[src]});
        
        while(!q.empty()){
            auto [u, uw] = q.front();
            q.pop();
            
            for(auto x: adj[u]){
                auto [v, vw] = x;
                if((dist[u] + vw) < dist[v]){
                    dist[v] = dist[u]+vw;
                    q.push({v, dist[v]});
                }
            }
        }
        
        return (dist[dest] == 1LL * INT_MAX) ? -1 : dist[dest];
    }
};