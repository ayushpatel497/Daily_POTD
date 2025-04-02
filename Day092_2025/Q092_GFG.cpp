//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    // Function to return Breadth First Traversal of given graph.
    vector<int> bfs(vector<vector<int>> &adj) {
        // Q. BFS of graph
        // Code here
        int nodeCount = adj.size();
        vector<int> answer;
        vector<bool> visited(nodeCount, false);
        queue<int> nodeQueue;
        visited[0] = true;
        nodeQueue.push(0);
        while(!nodeQueue.empty()){
            int node = nodeQueue.front();
            nodeQueue.pop();
            answer.push_back(node);
            for(auto neighbor : adj[node]){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    nodeQueue.push(neighbor);
                }
            }
        }
        return answer;
    }
};


//{ Driver Code Starts.

int main() {
    int tc;
    cin >> tc;
    cin.ignore();
    while (tc--) {
        int V;
        cin >> V;
        cin.ignore();
        // Use vector of vectors instead of array of vectors.
        vector<vector<int>> adj(V);

        for (int i = 0; i < V; i++) {
            string input;
            getline(cin, input);
            int num;
            vector<int> node;
            stringstream ss(input);
            while (ss >> num) {
                node.push_back(num);
            }
            adj[i] = node;
        }

        Solution obj;
        vector<int> ans = obj.bfs(adj);
        for (int i = 0; i < ans.size(); i++) {
            cout << ans[i] << " ";
        }
        cout << endl;
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends