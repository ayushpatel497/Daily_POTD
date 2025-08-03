class Q215_Leetcode {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int left = 0, right = 0, sum = 0, ans = 0;
        java.util.function.BiFunction<Integer, Integer, Integer> step = (l, r) -> {
            if (fruits[r][0] <= startPos) {
                return startPos - fruits[l][0];
            } else if (fruits[l][0] >= startPos) {
                return fruits[r][0] - startPos;
            } else {
                return Math.min(Math.abs(startPos - fruits[r][0]), Math.abs(startPos - fruits[l][0])) +
                       fruits[r][0] - fruits[l][0];
            }
        };

        while (right < n) {
            sum += fruits[right][1];
            while (left <= right && step.apply(left, right) > k) {
                sum -= fruits[left][1];
                left++;
            }
            ans = Math.max(ans, sum);
            right++;
        }

        return ans;
    }
}
