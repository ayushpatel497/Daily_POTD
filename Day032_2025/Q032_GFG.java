class Q032_GFG {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean checkMoreCharacters(char[][] mat, String word, int row, int col, int rowSize, int colSize, boolean[][] visited, int index) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= rowSize || col >= colSize || visited[row][col] || mat[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (checkMoreCharacters(mat, word, newRow, newCol, rowSize, colSize, visited, index + 1)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }

    public boolean isWordExist(char[][] mat, String word) {
        int rowSize = mat.length;
        int colSize = mat[0].length;
        boolean[][] visited = new boolean[rowSize][colSize];

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (checkMoreCharacters(mat, word, row, col, rowSize, colSize, visited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
