class Q141_Leetcode {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean flagR = false;
        boolean flagC = false;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagC = true;
            }
        }

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagR = true;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (flagR) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (flagC) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
