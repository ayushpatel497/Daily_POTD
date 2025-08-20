class Q232_GFG {
    public boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;
        int size = n * m;
        int s = 0, e = size - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            int ele = mat[mid / m][mid % m];
            int start = mat[s / m][s % m];
            int end = mat[e / m][e % m];

            if (ele == x) return true;

            else if (ele > end) {
                if (start <= x && ele > x) e = mid - 1;
                else s = mid + 1;
            } else {
                if (end >= x && x > ele) s = mid + 1;
                else e = mid - 1;
            }
        }
        return false;
    }
}
