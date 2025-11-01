class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length - 2;
        long sum = 0, squaredSum = 0;

        for (int x : nums) {
            sum += x;
            squaredSum += (long) x * x;
        }

        long expectedSum = (long) n * (n - 1) / 2;
        long expectedSquaredSum = (long) n * (n - 1) * (2L * n - 1) / 6;

        long sum2 = sum - expectedSum;
        long squaredSum2 = squaredSum - expectedSquaredSum;

        double sqrtVal = Math.sqrt(2.0 * squaredSum2 - sum2 * sum2);
        int x1 = (int) ((sum2 - sqrtVal) / 2.0);
        int x2 = (int) ((sum2 + sqrtVal) / 2.0);

        return new int[]{x1, x2};
    }
}
