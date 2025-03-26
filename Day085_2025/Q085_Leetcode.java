import java.util.*;

class Q085_Leetcode {
    public int minOperations(int[][] grid, int x) {
        List<Integer> numsArray = new ArrayList<>();
        
        // Flatten the grid and check divisibility
        int baseMod = grid[0][0] % x;
        for (int[] row : grid) {
            for (int num : row) {
                if (num % x != baseMod) return -1; // If mod values don't match, return -1
                numsArray.add(num);
            }
        }

        // Sort the array to find the median
        Collections.sort(numsArray);
        int median = numsArray.get(numsArray.size() / 2);
        int result = 0;

        // Calculate the total operations needed
        for (int num : numsArray) {
            result += Math.abs(num - median) / x;
        }

        return result;
    }
}
