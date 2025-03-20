class Solution {
    int getComponentCost(int source, vector<vector<pair<int, int>>>& adjList, vector<bool>& visited, vector<int>& components, int componentId) {
        queue<int> nodesQueue;
        int componentCost = INT_MAX;
        nodesQueue.push(source);
        visited[source] = true;
        while (!nodesQueue.empty()) {
            int node = nodesQueue.front();
            nodesQueue.pop();
            components[node] = componentId;
            for (auto& [neighbor, weight] : adjList[node]) {
                componentCost &= weight;
                if (visited[neighbor]) continue;
                visited[neighbor] = true;
                nodesQueue.push(neighbor);
            }
        }

        return componentCost;
    }
public:
    vector<int> minimumCost(int n, vector<vector<int>>& edges, vector<vector<int>>& query) {
        // Q. Minimum Cost Walk in Weighted Graph
        vector<vector<pair<int, int>>> adjList(n);
        for (auto& edge : edges) {
            adjList[edge[0]].push_back({edge[1], edge[2]});
            adjList[edge[1]].push_back({edge[0], edge[2]});
        }

        vector<bool> visited(n, false);
        vector<int> components(n);
        vector<int> componentCost;

        int componentId = 0;
        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                componentCost.push_back(getComponentCost(
                    node, adjList, visited, components, componentId));
                componentId++;
            }
        }

        vector<int> answer;

        for (auto& q : query) {
            int start = q[0];
            int end = q[1];

            if (components[start] == components[end]) {
                answer.push_back(componentCost[components[start]]);
            } else {
                answer.push_back(-1);
            }
        }

        return answer;
    }
};