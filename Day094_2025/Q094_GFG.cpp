//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
    void dfs(int node, vector<vector<int>> &adj, vector<int> &parent,vector<bool> &vis,bool &cycle){
        vis[node] = true;
        for(int child : adj[node]){
            if(parent[node] != child){
                if(!vis[child]){   
                    parent[child] = node;
                    dfs(child,adj,parent,vis,cycle);
                }
                else{
                    cycle = true;
                }
            }
        }
    }
  public:
    bool isCycle(int V, vector<vector<int>>& edges) {
        // Code here
        vector<vector<int>> adj(V);
        for(int i = 0; i < (int)edges.size(); i++)
        {
            int x = edges[i][0];
            int y = edges[i][1];
            adj[x].push_back(y);
            adj[y].push_back(x);
        }
        bool cycle = false;
        vector<int> parent(V, -1);
        vector<bool> vis(V, false);
        for(int i = 0; i < V; i++)
        {
            if(!vis[i])
            dfs(i, adj, parent, vis, cycle);    
        }
        return cycle;
    }
};


//{ Driver Code Starts.

int main() {
    int tc;
    cin >> tc;
    cin.ignore();
    while (tc--) {
        int V, E;
        cin >> V >> E;
        cin.ignore();
        vector<vector<int>> edges;
        for (int i = 1; i <= E; i++) {
            int u, v;
            cin >> u >> v;
            edges.push_back({u, v});
        }

        Solution obj;
        bool ans = obj.isCycle(V, edges);
        if (ans)
            cout << "true\n";
        else
            cout << "false\n";

        cout << "~"
             << "\n";
    }
    return 0;
}

// } Driver Code Ends