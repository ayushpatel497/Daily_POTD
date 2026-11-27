class Solution {
  public:
    int countEdges(vector<vector<int>> &adj) {
        // Q. Count Edges in Graph
        // code here
        int total = 0;
        for (auto &list : adj) {
            total += list.size();
        }
        return total / 2;
    }
};