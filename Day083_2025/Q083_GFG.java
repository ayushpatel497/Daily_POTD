
class Q083_GFG {
    public static int matrixMultiplication(int[] arr) {
        int arrSize = arr.length;
        int[][] dp = new int[arrSize][arrSize];

        for (int length = 2; length < arrSize; ++length) {
            for (int start = 1; start <= arrSize - length; ++start) {
                int end = start + length - 1;
                int minimum = Integer.MAX_VALUE;

                for (int index = start; index < end; ++index) {
                    int cost = dp[start][index] + dp[index + 1][end] + arr[start - 1] * arr[index] * arr[end];
                    minimum = Math.min(minimum, cost);
                }
                dp[start][end] = minimum;
            }
        }
        return dp[1][arrSize - 1];
    }
}
