import java.util.*;

class Q246_Leetcode {
    public int numberOfPairs(int[][] points) {
        int ans = 0;

        // Sort: by x ascending, and if tie, by y descending
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        for (int i = 0; i < points.length - 1; i++) {
            int[] pointA = points[i];
            int xMin = pointA[0] - 1;
            int xMax = Integer.MAX_VALUE;
            int yMin = Integer.MIN_VALUE;
            int yMax = pointA[1] + 1;

            for (int j = i + 1; j < points.length; j++) {
                int[] pointB = points[j];
                if (pointB[0] > xMin && pointB[0] < xMax &&
                    pointB[1] > yMin && pointB[1] < yMax) {
                    
                    ans++;
                    xMin = pointB[0];
                    yMin = pointB[1];
                }
            }
        }

        return ans;
    }
}
