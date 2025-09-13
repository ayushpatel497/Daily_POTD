import java.util.Arrays;
import java.util.Collections;

class Q256_GFG {
    public static int minCost(int n, int m, int[] x, int[] y) {
        // Sort in descending order
        Integer[] xArr = Arrays.stream(x).boxed().toArray(Integer[]::new);
        Integer[] yArr = Arrays.stream(y).boxed().toArray(Integer[]::new);
        
        Arrays.sort(xArr, Collections.reverseOrder());
        Arrays.sort(yArr, Collections.reverseOrder());
        
        int horizontalPieces = 1;
        int verticalPieces = 1;
        int i = 0, j = 0;
        int totalCost = 0;
        int mod = (int)1e9 + 7; // optional if constraints are big

        while (i < xArr.length && j < yArr.length) {
            if (xArr[i] > yArr[j]) {
                totalCost = (totalCost + xArr[i] * horizontalPieces) % mod;
                verticalPieces++;
                i++;
            } else {
                totalCost = (totalCost + yArr[j] * verticalPieces) % mod;
                horizontalPieces++;
                j++;
            }
        }

        while (i < xArr.length) {
            totalCost = (totalCost + xArr[i] * horizontalPieces) % mod;
            i++;
        }

        while (j < yArr.length) {
            totalCost = (totalCost + yArr[j] * verticalPieces) % mod;
            j++;
        }

        return totalCost;
    }
}
