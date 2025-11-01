class Solution {
    vector<vector<int> > make_graph(int numTasks, vector<vector<int>>& prerequisites){
        vector<vector<int> > graph(numTasks);
        for (auto pre : prerequisites)
            graph[pre[1]].push_back(pre[0]);
        return graph;
    }

    vector<int> compute_indegree(vector<vector<int> >& graph){
        vector<int> degrees(graph.size(), 0);
        for (auto neighbors : graph)
            for (int neigh : neighbors)
                degrees[neigh]++;
        return degrees;
    }
  public:
    vector<int> findOrder(int n, vector<vector<int>> &prerequisites) {
        // Q. Course Schedule II
        // code here
        vector<vector<int>> graph = make_graph(n, prerequisites);
        vector<int> degrees = compute_indegree(graph);
        queue<int> zeros;
        for (int i = 0; i < n; i++)
            if (!degrees[i])
                zeros.push(i);
        vector<int> toposort;
        for (int i = 0; i < n; i++) {
            if (zeros.empty())
                return {};
            int zero = zeros.front();
            zeros.pop();
            toposort.push_back(zero);
            for (int neigh : graph[zero]) {
                if (!--degrees[neigh])
                    zeros.push(neigh);
            }
        }
        return toposort;
    }
};