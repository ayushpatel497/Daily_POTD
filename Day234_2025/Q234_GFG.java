import java.util.*;

class Q234_GFG {
    public int median(int[][] mat) {
        List<Integer> val = new ArrayList<>();
        int n = mat.length, m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                val.add(mat[i][j]);
            }
        }

        Collections.sort(val);
        return val.get((n * m) / 2);
    }
}
