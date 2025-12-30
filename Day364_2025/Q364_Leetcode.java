class Q364_Leetcode {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        for (int r = 0; r < m - 2; r++) {
            for (int c = 0; c < n - 2; c++) {
                if (isMagic(grid, r, c)) ans++;
            }
        }
        return ans;
    }

    private boolean isMagic(int[][] grid, int r, int c) {
        int[] freq = new int[16];

        // check numbers 1..9 and uniqueness
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[r + i][c + j];
                if (num <= 0 || num >= 10) return false;
                if (++freq[num] > 1) return false;
            }
        }

        int d1 = grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2];
        int d2 = grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c];
        if (d1 != d2) return false;

        for (int i = 0; i < 3; i++) {
            int rowSum = grid[r + i][c] + grid[r + i][c + 1] + grid[r + i][c + 2];
            int colSum = grid[r][c + i] + grid[r + 1][c + i] + grid[r + 2][c + i];

            if (rowSum != d1 || colSum != d2) return false;
        }
        return true;
    }
}
