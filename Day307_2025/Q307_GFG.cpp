class Solution {
  public:
    vector<int> safeNodes(int V, vector<vector<int>>& edges) {
        // Q. Safe States
        // Code here
        vector<vector<int>> reverseGraph(V);
        vector<int> outDegree(V, 0);
        for(auto edge : edges){
            int u = edge[0], v = edge[1];
            reverseGraph[v].push_back(u);
            outDegree[u]++;
        }
        
        queue<int> bfsQ;
        for(int node = 0; node < V; ++node){
            if(outDegree[node] == 0){
                bfsQ.push(node);
            }
        }
        
        vector<int> safeNodes;
        while(!bfsQ.empty()){
            int node = bfsQ.front();
            bfsQ.pop();
            safeNodes.push_back(node);
            for(int parent : reverseGraph[node]){
                outDegree[parent]--;
                if(outDegree[parent] == 0){
                    bfsQ.push(parent);
                }
            }
        }
        sort(safeNodes.begin(), safeNodes.end());
        return safeNodes;
    }
};