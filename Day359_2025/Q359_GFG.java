import java.util.*;

class Q259_GFG {
    public ArrayList<Integer> findPeakGrid(int[][] mat) {
        ArrayList<Integer> ans = new ArrayList<>();

        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean top = (i == 0) || (mat[i - 1][j] <= mat[i][j]);
                boolean bottom = (i == n - 1) || (mat[i + 1][j] <= mat[i][j]);
                boolean left = (j == 0) || (mat[i][j - 1] <= mat[i][j]);
                boolean right = (j == m - 1) || (mat[i][j + 1] <= mat[i][j]);

                if (top && bottom && left && right) {
                    ans.add(i);
                    ans.add(j);
                    return ans;
                }
            }
        }
        return ans;
    }
}
