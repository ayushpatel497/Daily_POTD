import java.util.*;

class Q361_GFG {
    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length;
        int n = m * m;
        int[] arr = new int[n];

        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                arr[idx++] = mat[i][j];
            }
        }

        Arrays.sort(arr);
        return arr[k - 1];
    }
}
