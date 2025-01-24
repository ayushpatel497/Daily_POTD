class Solution {
public:
    bool dfsCall(int node, vector<vector<int>>& adj, vector<bool>& visited, vector<bool>& inStack){
        if(inStack[node]){
            return true;
        }
        if(visited[node]){
            return false;
        }
        visited[node] = true;
        inStack[node] = true;
        for(auto neighbor : adj[node]){
            if(dfsCall(neighbor, adj, visited, inStack)){
                return true;
            }
        }
        inStack[node] = false;
        return false;
    }
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        // Q. Find Eventual Safe States
        int nodeCount = graph.size();

        vector<bool> visited(nodeCount);
        vector<bool> inStack(nodeCount);
        for(int node = 0; node < nodeCount; ++node){
            dfsCall(node, graph, visited, inStack);
        }

        vector<int> topoSort;
        for (int node = 0; node < nodeCount; ++node) {
            if (!inStack[node]) {
                topoSort.push_back(node);
            }
        }
        
        return topoSort;
    }
};