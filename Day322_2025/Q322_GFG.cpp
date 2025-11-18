class Solution {
  public:
    int countPaths(int V, vector<vector<int>>& edges) {
        // Q. Number of Ways to Arrive at Destination
        // code here
        int MOD = 1e9 + 7;
        
        vector<vector<pair<int, int>>> adj(V);
        for (int i = 0; i < edges.size(); i++) {
            adj[edges[i][0]].push_back({edges[i][1], edges[i][2]});
            adj[edges[i][1]].push_back({edges[i][0], edges[i][2]});
        }
        
        vector<long long> dist (V, LLONG_MAX);
        vector<int> ways(V, 0);
        dist[0] = 0;
        ways[0] = 1;
        
        priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> pq;
        pq.push({0, 0});
        
        while(!pq.empty()) {
            long long distance = pq.top().first;
            int node = pq.top().second;
            
            pq.pop();
            
            for (auto nbr: adj[node]) {
                int adjNode = nbr.first;
                int wt = nbr.second;
                
                if (distance + wt < dist[adjNode]) {
                    dist[adjNode] = distance + wt;
                    pq.push({dist[adjNode], adjNode});
                    ways[adjNode] = ways[node];
                }
                else if (distance + wt == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % MOD;
                }
            }
        }
        return ways[V-1];
    }
};