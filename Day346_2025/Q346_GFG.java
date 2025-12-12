import java.util.ArrayList;

class Q346_GFG {
    public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
        int n = mat.length;

        // In-place transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Convert to ArrayList<ArrayList<Integer>>
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(mat[i][j]);
            }
            res.add(row);
        }
        return res;
    }
}
