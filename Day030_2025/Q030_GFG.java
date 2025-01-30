import java.util.*;

class Q030_GFG {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private int[] row;

    private boolean isSafe(int r, int c) {
        for (int prev = 0; prev < c; prev++) {
            if (row[prev] == r || Math.abs(row[prev] - r) == Math.abs(prev - c)) {
                return false;
            }
        }
        return true;
    }

    private void solveNQueens(int column, int n) {
        if (n == 2 || n == 3) return;
        
        if (column == n) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(row[i] + 1);
            }
            result.add(temp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(i, column)) {
                row[column] = i;
                solveNQueens(column + 1, n);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        result.clear();
        row = new int[n];
        solveNQueens(0, n);
        return result;
    }
}
