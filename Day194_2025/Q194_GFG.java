import java.util.Arrays;

class Q194_GFG{
    public int nonLisMaxSum(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] temp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            temp[i] = i; // each element starts pointing to itself
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] <= dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    temp[i] = j;
                }
            }
        }

        int total = 0, maxLen = 0, index = -1;
        for (int i = 0; i < n; i++) {
            total += arr[i];
            if (dp[i] >= maxLen) {
                maxLen = dp[i];
                index = i;
            }
        }

        int lisSum = arr[index];
        maxLen--;
        while (maxLen > 0) {
            index = temp[index];
            lisSum += arr[index];
            maxLen--;
        }

        return total - lisSum;
    }
}
