import java.util.ArrayList;
import java.util.List;

class Q208_GFG {
    public void setMatrixZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        List<int[]> zeroPositions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    zeroPositions.add(new int[]{i, j});
                }
            }
        }

        for (int[] pos : zeroPositions) {
            int row = pos[0];
            int col = pos[1];
            for (int i = 0; i < m; i++) {
                mat[row][i] = 0;
            }
            for (int i = 0; i < n; i++) {
                mat[i][col] = 0;
            }
        }
    }
}
