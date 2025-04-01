//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
    void fillAnswer(int node, vector<vector<int>> adj, vector<int>& answer, vector<bool>& visited){
        visited[node] = true;
        answer.push_back(node);
        for(auto neighbor : adj[node]){
            if(!visited[neighbor]){
                fillAnswer(neighbor, adj, answer, visited);
            }
        }
    }
  public:
    vector<int> dfs(vector<vector<int>>& adj) {
        // Q. DFS of Graph
        // Code here
        int nodeCount = adj.size();
        vector<int> answer;
        vector<bool> visited(nodeCount, false);
        
        for(int node = 0; node < nodeCount; ++node){
            if(!visited[node]){
                fillAnswer(node, adj, answer, visited);
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
        vector<vector<int>> adj(
            V); // Use vector of vectors instead of array of vectors.

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
        vector<int> ans = obj.dfs(adj);
        for (int i = 0; i < ans.size(); i++) {
            cout << ans[i] << " ";
        }
        cout << endl;
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends