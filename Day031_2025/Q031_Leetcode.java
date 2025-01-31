import java.util.*;

class Q031_Leetcode {
    private int exploreIsland(int[][] grid, int islandId, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) {
            return 0;
        }
        
        grid[row][col] = islandId;
        return 1 + exploreIsland(grid, islandId, row + 1, col) +
                   exploreIsland(grid, islandId, row - 1, col) +
                   exploreIsland(grid, islandId, row, col + 1) +
                   exploreIsland(grid, islandId, row, col - 1);
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> islandSizes = new HashMap<>();
        int islandId = 2;
        
        // Step 1: Assign unique island IDs and compute sizes
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    islandSizes.put(islandId, exploreIsland(grid, islandId, row, col));
                    islandId++;
                }
            }
        }

        if (islandSizes.isEmpty()) return 1;

        int maxIslandSize = Collections.max(islandSizes.values());

        // Step 2: Try converting each 0 into 1 and check the largest island possible
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    Set<Integer> neighboringIslands = new HashSet<>();
                    
                    // Check 4 directions
                    if (row > 0 && grid[row - 1][col] > 1) neighboringIslands.add(grid[row - 1][col]);
                    if (row < n - 1 && grid[row + 1][col] > 1) neighboringIslands.add(grid[row + 1][col]);
                    if (col > 0 && grid[row][col - 1] > 1) neighboringIslands.add(grid[row][col - 1]);
                    if (col < n - 1 && grid[row][col + 1] > 1) neighboringIslands.add(grid[row][col + 1]);

                    int newIslandSize = 1; // The converted cell itself
                    for (int id : neighboringIslands) {
                        newIslandSize += islandSizes.get(id);
                    }
                    maxIslandSize = Math.max(maxIslandSize, newIslandSize);
                }
            }
        }

        return maxIslandSize;
    }
}
