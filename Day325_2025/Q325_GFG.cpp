class Solution {
    vector<int> dijkstra(int a,int b,int n,vector<pair<int,int>> adj[]){
        vector<int> dist(n+1,1e9);
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> pq;
        dist[a]=0;
        pq.push({0,a});
        
        while(!pq.empty()){
            auto curr=pq.top();
            pq.pop();
            int dis=curr.first;
            int node=curr.second;
            
            for(auto it:adj[node]){
                int v=it.first;
                int wt=it.second;
                if(dist[v]>dist[node]+wt){
                    dist[v]=dist[node]+wt;
                    pq.push({dist[v],v});
                }
            }
        }
        return dist;
    }
  public:
    int shortestPath(int V, int a, int b, vector<vector<int>> &edges) {
        // Q. Shortest Path Using Atmost One Curved Edge
        // code here
        vector<pair<int,int>> adj[V+1];
        vector<vector<int>> curved;
        int m = edges.size();
        
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            int cwt=edges[i][3];
            
            adj[u].push_back({v,wt});
            adj[v].push_back({u,wt});
            
            curved.push_back({u,v,cwt});
        }
        vector<int> dist1=dijkstra(a,b,V,adj);
        vector<int> dist2=dijkstra(b,a,V,adj);
        
        int ans=dist1[b];
        
        for(int i=0;i<m;i++){
            int u=curved[i][0];
            int v=curved[i][1];
            int cwt=curved[i][2];
            
            ans=min(ans,dist1[u]+cwt+dist2[v]);
            ans=min(ans,dist1[v]+cwt+dist2[u]);
        }
        
        if(ans>=1e9) return -1;
        return ans;
    }
};