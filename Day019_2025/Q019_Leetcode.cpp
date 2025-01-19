class Solution {
public:
    int trapRainWater(vector<vector<int>>& heightMap) {
        // Q. Trapping Rain Water II
        int directionRow[4] = {0, 0, -1, 1};
        int directionCol[4] = {-1, 1, 0, 0};
        int rowSize = heightMap.size();
        int colSize = heightMap[0].size();
        vector<vector<bool>> visited(rowSize, vector<bool>(colSize, false));
        priority_queue<Cell> boundary;

        for(int row = 0; row < rowSize; ++row){
            boundary.push(Cell(heightMap[row][0], row, 0));
            boundary.push(Cell(heightMap[row][colSize - 1], row, colSize - 1));
            visited[row][0] = visited[row][colSize - 1] = true;
        }

        for(int col = 0; col < colSize; ++col){
            boundary.push(Cell(heightMap[0][col], 0, col));
            boundary.push(Cell(heightMap[rowSize - 1][col], rowSize - 1, col));
            visited[0][col] = visited[rowSize - 1][col] = true;
        }

        int totalWaterVolume = 0;
        while(!boundary.empty()){
            Cell currentCell = boundary.top();
            boundary.pop();

            int minBoundaryHeight = currentCell.height;
            int currentRow = currentCell.row;
            int currentCol = currentCell.col;

            for(int direction = 0; direction < 4; ++direction){
                int neighborRow = currentRow + directionRow[direction];
                int neighborCol = currentCol + directionCol[direction];

                if(isValidCell(neighborRow, neighborCol, rowSize, colSize) && !visited[neighborRow][neighborCol]){
                    int neighborHeight = heightMap[neighborRow][neighborCol];

                    if(neighborHeight < minBoundaryHeight){
                        totalWaterVolume += minBoundaryHeight - neighborHeight;
                    }

                    boundary.push(Cell(max(neighborHeight, minBoundaryHeight), neighborRow, neighborCol));
                    visited[neighborRow][neighborCol] = true;
                }
            }
        }
        return totalWaterVolume;
    }
private:
    class Cell{
        public:
        int height;
        int row;
        int col;
        Cell(int height, int row, int col){
            this -> height = height;
            this -> row = row;
            this -> col = col;
        }

        bool operator<(const Cell& other) const {
            return height >= other.height;
        }
    };

    bool isValidCell(int row, int col, int rowSize, int colSize){
        return row >= 0 && col >= 0 && row < rowSize && col < colSize;
    }
};