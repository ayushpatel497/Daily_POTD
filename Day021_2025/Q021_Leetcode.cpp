class Solution {
public:
    long long gridGame(vector<vector<int>>& grid) {
        // Q. Grid Game
        long long firstRowSum = accumulate(grid[0].begin(), grid[0].end(), 0LL);
        long long secondRowSum = 0;
        long long minimumSum = LONG_LONG_MAX;
        for(int turnIndex = 0; turnIndex < grid[0].size(); ++turnIndex){
            firstRowSum -= grid[0][turnIndex];
            minimumSum = min(minimumSum, max(firstRowSum, secondRowSum));
            secondRowSum += grid[1][turnIndex];
        }
        return minimumSum;
    }
};