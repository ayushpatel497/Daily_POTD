class Solution {
public:
    int countServers(vector<vector<int>>& grid) {
        // Q. Count Servers that Communicate
        int communicableServers = 0;
        vector<int> rowCounts(grid[0].size(), 0);
        vector<int> lastServerInCol(grid.size(), -1);

        for(int row = 0; row < grid.size(); ++row){
            int serverCountInRow = 0;
            for(int col = 0; col < grid[0].size(); ++col){
                if(grid[row][col]){
                    serverCountInRow += 1;
                    rowCounts[col] += 1;
                    lastServerInCol[row] = col;
                }
            }
            if(serverCountInRow != 1){
                communicableServers += serverCountInRow;
                lastServerInCol[row] = -1;
            }
        }

        for(int row = 0; row < grid.size(); ++row){
            communicableServers += lastServerInCol[row] != -1 && rowCounts[lastServerInCol[row]] > 1;
        }
        return communicableServers;
    }
};