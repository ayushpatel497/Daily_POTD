class Q140_Leetcode {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] deltaArray = new int[n + 1];

        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            deltaArray[left] += 1;
            if (right + 1 < deltaArray.length) {
                deltaArray[right + 1] -= 1;
            }
        }

        int[] operationCounts = new int[n];
        int currentOperations = 0;
        for (int i = 0; i < n; i++) {
            currentOperations += deltaArray[i];
            operationCounts[i] = currentOperations;
        }

        for (int i = 0; i < n; i++) {
            if (operationCounts[i] < nums[i]) {
                return false;
            }
        }

        return true;
    }
}
