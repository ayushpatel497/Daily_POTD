class Q347_GFG {
    public void swapDiagonal(int[][] mat) {
        int n = mat.length;
        int j = n - 1;

        for (int i = 0; i < n; i++) {
            int temp = mat[i][i];
            mat[i][i] = mat[i][j];
            mat[i][j] = temp;
            j--;
        }
    }
}
