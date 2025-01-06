class Q006_Leetcode {
    public int[] minOperations(String boxes) {
        // Q. Minimum Number of Operations to Move All Balls to Each Box
        int n = boxes.length();
        int[] ans = new int[n];

        int ballsToLeft = 0, movesToLeft = 0;
        int ballsToRight = 0, movesToRight = 0;

        // Calculate operations from left to right
        for (int i = 0; i < n; i++) {
            ans[i] += movesToLeft;
            ballsToLeft += boxes.charAt(i) - '0';
            movesToLeft += ballsToLeft;
        }

        // Calculate operations from right to left
        for (int i = n - 1; i >= 0; i--) {
            ans[i] += movesToRight;
            ballsToRight += boxes.charAt(i) - '0';
            movesToRight += ballsToRight;
        }

        return ans;
    }

    public static void main(String[] args) {
        Q006_Leetcode sol = new Q006_Leetcode();
        String boxes = "110";
        int[] result = sol.minOperations(boxes);
        for (int res : result) {
            System.out.print(res + " ");
        }
    }
}
