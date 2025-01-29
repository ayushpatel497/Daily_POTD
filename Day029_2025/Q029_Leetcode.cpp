class Solution {
    int findParent(int node, vector<int> parent) {
        if (parent[node] == -1) {
            return node;
        }
        return parent[node] = findParent(parent[node], parent);
    }
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        // Q. Redundant Connection
        int edgesSize = edges.size();
        vector<int> parent(edgesSize + 1, -1);
        for (auto edge : edges) {
            int edgeNodeOne = edge[0];
            int edgeNodeTwo = edge[1];
            int parentEdgeNodeOne = findParent(edgeNodeOne, parent);
            int parentEdgeNodeTwo = findParent(edgeNodeTwo, parent);
            if (parentEdgeNodeOne == parentEdgeNodeTwo) {
                return edge;
            }
            parent[parentEdgeNodeOne] = parentEdgeNodeTwo;
        }
        return {}; 
    }
};