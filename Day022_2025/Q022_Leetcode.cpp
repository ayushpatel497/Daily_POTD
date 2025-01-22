class Solution {
public:
    vector<vector<int>> highestPeak(vector<vector<int>>& isWater) {
        // Q. Map of Highest Peak
        int directionX[4] = {0, 0, 1, -1};
        int directionY[4] = {1, -1, 0, 0};
        int rowSize = isWater.size();
        int colSize = isWater[0].size();
        vector<vector<int>> cellHeights(rowSize, vector<int>(colSize, -1));
        queue<pair<int, int>> cellQueue;

        for(int x = 0; x < rowSize; ++x){
            for(int y = 0; y < colSize; ++y){
                if(isWater[x][y]){
                    cellQueue.push({x, y});
                    cellHeights[x][y] = 0;
                }
            }
        }

        int heightOfNextLayer = 1;
        while(!cellQueue.empty()){
            int layerSize = cellQueue.size();
            for(int size = 0; size < layerSize; ++size){
                pair<int, int> currentCell = cellQueue.front();
                cellQueue.pop();
                for(int direction = 0; direction < 4; ++direction){
                    pair<int, int> neighborCell = {currentCell.first + directionX[direction], currentCell.second + directionY[direction]};
                    if(isValidCell(neighborCell, rowSize, colSize) && cellHeights[neighborCell.first][neighborCell.second] == -1){
                        cellHeights[neighborCell.first][neighborCell.second] = heightOfNextLayer;
                        cellQueue.push(neighborCell); 
                    }
                }
            }
            heightOfNextLayer += 1;
        }
        return cellHeights;
    }

    bool isValidCell(pair<int, int> cell, int rowSize, int colSize){
        return cell.first >= 0 && cell.second >= 0 && cell.first < rowSize && cell.second < colSize;
    }
};