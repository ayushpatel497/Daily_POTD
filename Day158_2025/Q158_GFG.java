import java.util.Arrays;

class Q158_GFG {
    public int longestCommonSum(int[] a1, int[] a2) {
        int n = a1.length;
        int[] diff = new int[2 * n + 1];
        Arrays.fill(diff, -1);
        
        int sum1 = 0, sum2 = 0, res = 0;

        for (int i = 0; i < n; i++) {
            sum1 += a1[i];
            sum2 += a2[i];
            int currentDiff = sum1 - sum2;
            int index = currentDiff + n;

            if (currentDiff == 0) {
                res = Math.max(res, i + 1);
            } else if (diff[index] != -1) {
                res = Math.max(res, i - diff[index]);
            } else {
                diff[index] = i;
            }
        }

        return res;
    }
}
