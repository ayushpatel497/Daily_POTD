//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

// User function Template for C++

class Solution {
  public:
    vector<int> bellmanFord(int V, vector<vector<int>>& edges, int src) {
        // Q. Bellman-Ford
        // Code here
        vector<int> dist(V, 1e8);
        dist[src] = 0;
        for(int i = 0; i < V; ++i){
            for(int j = 0; j < edges.size(); ++j){
                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];
                if(dist[u] != 1e8 && dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }
        
        for(int j = 0; j < edges.size(); ++j){
            int u = edges[j][0];
            int v = edges[j][1];
            int w = edges[j][2];
            if(dist[u] != 1e8 && dist[u] + w < dist[v]){
                return {-1};
            }
        }
        
        return dist;
    }
};



//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        int V, E;
        cin >> V >> E;

        vector<vector<int> > edges;

        for (int i = 0; i < E; ++i) {
            int u, v, w;
            cin >> u >> v >> w;

            vector<int> edge(3);
            edge[0] = u;
            edge[1] = v;
            edge[2] = w;
            edges.push_back(edge);
        }

        int src;
        cin >> src;
        cin.ignore();

        Solution obj;
        vector<int> res = obj.bellmanFord(V, edges, src);

        for (size_t i = 0; i < res.size(); i++) {
            cout << res[i] << " ";
        }
        cout << "\n";
        cout << "~" << endl;
    }
    return 0;
}
// } Driver Code Ends