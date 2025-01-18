class Solution {
public:
    vector<vector<int>> directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    int minCost(vector<vector<int>>& grid) {
        // Q. Minimum Cost to Make at Least One Valid Path in a Grid
        int rowSize = grid.size();
        int colSize = grid[0].size();

        vector<vector<int>> minimumCost(rowSize, vector<int>(colSize, INT_MAX));
        deque<pair<int, int>> positionDeque;
        positionDeque.push_front({0, 0});
        minimumCost[0][0] = 0;

        while(!positionDeque.empty()){
            auto [row, col] = positionDeque.front();
            positionDeque.pop_front();

            for(int direction = 0; direction < 4; ++direction){
                int newRow = row + directions[direction][0];
                int newCol = col + directions[direction][1];
                int cost = (grid[row][col] != (direction + 1)) ? 1 : 0;
                if(isValid(newRow, newCol, rowSize, colSize) && (minimumCost[row][col] + cost < minimumCost[newRow][newCol])){
                    minimumCost[newRow][newCol] = minimumCost[row][col] + cost;

                    if(cost == 1){
                        positionDeque.push_back({newRow, newCol});
                    }
                    else{
                        positionDeque.push_front({newRow, newCol});
                    }
                }
            }
        }
        return minimumCost[rowSize - 1][colSize - 1];
    }

    bool isValid(int newRow, int newCol, int rowSize, int colSize){
        return newRow >= 0 && newCol >= 0 && newRow < rowSize && newCol <colSize;
    }
};