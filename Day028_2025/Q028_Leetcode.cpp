class Solution {
    vector<pair<int, int>> directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    void getMaxFishes(int row, int col, int rowSize, int colSize, vector<vector<int>>& grid, int& currentFishes){
        currentFishes += grid[row][col];
        grid[row][col] = 0;
        for(auto [r, c] : directions){
            int newRow = r + row;
            int newCol = c + col;
            if(isValid(newRow, newCol, rowSize, colSize) && grid[newRow][newCol] != 0){
                getMaxFishes(newRow, newCol, rowSize, colSize, grid, currentFishes);
            }
        }
    }
    bool isValid(int row, int col, int rowSize, int colSize){
        return row >= 0 && col >= 0 && row < rowSize && col < colSize;
    }
public:
    int findMaxFish(vector<vector<int>>& grid) {
        // Q. Maximum Number of Fish in a Grid
        int rowSize = grid.size();
        int colSize = grid[0].size();
        int maxFishes = 0;
        for(int row = 0; row < rowSize; ++row){
            for(int col = 0; col < colSize; ++col){
                if(grid[row][col] != 0){
                    int currentFishes = 0;
                    getMaxFishes(row, col, rowSize, colSize, grid, currentFishes);
                    maxFishes = max(maxFishes, currentFishes);
                }
            }
        }
        return maxFishes;
    }
};