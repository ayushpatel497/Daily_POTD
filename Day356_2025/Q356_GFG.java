class Q356_GFG {
    public int rowWithMax1s(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;

        int maxRow = -1;
        int maxOnes = -1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    count = m - j;
                    break;
                }
            }

            if (count > maxOnes) {
                maxOnes = count;
                maxRow = i;
            }
        }

        return maxRow;
    }
}
