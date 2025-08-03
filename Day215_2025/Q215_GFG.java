import java.util.*;

class Q215_GFG {
    public ArrayList<ArrayList<Integer>> applyDiff2D(int[][] mat, int[][] opr) {
        int n = mat.length, m = mat[0].length;
        int[][] temp = new int[n][m];

        for (int[] x : opr) {
            int val = x[0], r1 = x[1], c1 = x[2], r2 = x[3], c2 = x[4];
            temp[r2][c2] += val;

            if (r1 - 1 >= 0 && c1 - 1 >= 0)
                temp[r1 - 1][c1 - 1] += val;

            if (c1 - 1 >= 0)
                temp[r2][c1 - 1] -= val;

            if (r1 - 1 >= 0)
                temp[r1 - 1][c2] -= val;
        }

        for (int i = 0; i < n; ++i) {
            for (int j = m - 2; j >= 0; --j) {
                temp[i][j] += temp[i][j + 1];
            }
        }

        for (int i = n - 2; i >= 0; --i) {
            for (int j = 0; j < m; ++j) {
                temp[i][j] += temp[i + 1][j];
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; ++j) {
                row.add(temp[i][j] + mat[i][j]);
            }
            result.add(row);
        }

        return result;
    }
}
