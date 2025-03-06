class Q065_Leetcode {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long sum = 0, sqrSum = 0;
        int n = grid.length;
        int total = n * n;

        for (int[] row : grid) {
            for (int num : row) {
                sum += num;
                sqrSum += (long) num * num;
            }
        }

        long sumDiff = sum - (long) total * (total + 1) / 2;
        long sqrDiff = sqrSum - (long) total * (total + 1) * (2 * total + 1) / 6;

        int repeat = (int) ((sqrDiff / sumDiff + sumDiff) / 2);
        int missing = (int) ((sqrDiff / sumDiff - sumDiff) / 2);

        return new int[]{repeat, missing};
    }
}
