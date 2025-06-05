class Solution {
  public:
    int countPaths(vector<vector<int>>& edges, int V, int src, int dest) {
        // Q. Count the paths
        // Code here
        vector<vector<int>> adj(V);
        vector<int> inDeg(V, 0);
        for (auto e: edges) {
            adj[e[0]].push_back(e[1]);
            inDeg[e[1]]++;
        }
    
        queue<int> q;
        for (int i = 0; i < V; i++) {
            if (inDeg[i] == 0) q.push(i);
        }
    
        vector<int> paths(V, 0);
        paths[src] = 1;
    
        while (!q.empty()) {
            int u = q.front(); q.pop();
            for (int v : adj[u]) {
                paths[v] += paths[u];
                if (--inDeg[v] == 0) {
                    q.push(v);
                }
            }
        }
    
        return paths[dest];
    }
};