import java.util.*;

class Q084_Leetcode {
    private boolean checkCuts(int[][] rectangles, int dim) {
        int gapCount = 0;
        Arrays.sort(rectangles, (a, b) -> Integer.compare(a[dim], b[dim]));
        int furthestEnd = rectangles[0][dim + 2];

        for (int i = 1; i < rectangles.length; i++) {
            if (furthestEnd <= rectangles[i][dim]) {
                gapCount++;
            }
            furthestEnd = Math.max(furthestEnd, rectangles[i][dim + 2]);
        }
        
        return gapCount >= 2;
    }

    public boolean checkValidCuts(int n, int[][] rectangles) {
        return checkCuts(rectangles, 0) || checkCuts(rectangles, 1);
    }
}
