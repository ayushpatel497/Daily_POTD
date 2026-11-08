class Solution {
public:
    int countServers(vector<vector<int>>& grid) {
        // Q. Count Servers that Communicate
        int rows = grid.size(), cols = grid[0].size();
        int communicableServersCount = 0;

        for (int rowIndex = 0; rowIndex < rows; ++rowIndex) {
            int rowCounts = 0;
            int serverColumnIndex = -1;
            for (int colIndex = 0; colIndex < cols; ++colIndex) {
                if (grid[rowIndex][colIndex]) {
                    if (rowCounts == 0) {
                        serverColumnIndex = colIndex;
                    }
                    rowCounts += 1;
                }
            }
            bool canCommunicate = (rowCounts !=1);
            if (!canCommunicate) {
                for (int i = 0; i < rows; ++i) {
                    if (i != rowIndex && grid[i][serverColumnIndex]) {
                        canCommunicate = true;
                        break;
                    }
                }
            }
            if (canCommunicate) {
                communicableServersCount += rowCounts;
            }
        }

        return communicableServersCount;
    }
};