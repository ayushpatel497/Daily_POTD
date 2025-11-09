class Q313_GFG {
    public int chocolatePickup(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] curr = new int[m][m];
        int[][] next = new int[m][m];

        for (int i1 = n - 1; i1 >= 0; i1--) {
            curr = new int[m][m];
            for (int j1 = m - 1; j1 >= 0; j1--) {
                for (int j2 = m - 1; j2 >= 0; j2--) {
                    if (i1 == n - 1 && j1 == m - 1 && j2 == m - 1) {
                        curr[m - 1][m - 1] = (mat[n - 1][m - 1] == -1) ? -1 : mat[n - 1][m - 1];
                        continue;
                    }

                    int i2 = i1 + j1 - j2;
                    if (i2 >= n || i2 < 0) continue;

                    int ans = -1;
                    int[][] dir = {{1, 0}, {0, 1}};
                    for (int[] d1 : dir) {
                        for (int[] d2 : dir) {
                            int newRow1 = i1 + d1[0];
                            int newCol1 = j1 + d1[1];
                            int newRow2 = i2 + d2[0];
                            int newCol2 = j2 + d2[1];

                            if (newRow1 < n && newRow2 < n && newCol1 < m && newCol2 < m &&
                                mat[newRow1][newCol1] != -1 && mat[newRow2][newCol2] != -1) {

                                if (newRow1 == i1 + 1)
                                    ans = Math.max(ans, next[newCol1][newCol2]);
                                else
                                    ans = Math.max(ans, curr[newCol1][newCol2]);
                            }
                        }
                    }

                    if (ans == -1 || mat[i1][j1] == -1 || mat[i2][j2] == -1) {
                        curr[j1][j2] = -1;
                        continue;
                    }

                    ans += mat[i1][j1];
                    if (i1 != i2 && mat[i2][j2] != -1)
                        ans += mat[i2][j2];

                    curr[j1][j2] = ans;
                }
            }
            next = curr;
        }
        return Math.max(0, next[0][0]);
    }
}
