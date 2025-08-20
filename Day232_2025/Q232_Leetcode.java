class Q232_Leetcode {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0 && j > 0 && matrix[i][j] > 0) {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1],
                                    Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
                }
                result += matrix[i][j];
            }
        }
        return result;
    }
}
