class Q206_Leetcode {
    public int maxSum(int[] nums) {
        Set<Integer> positiveNumsSet = new HashSet<>();
        int maxNum = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > 0) {
                positiveNumsSet.add(num);
            }
            maxNum = Math.max(maxNum, num);
        }

        if (positiveNumsSet.isEmpty()) {
            return maxNum;
        }

        int sum = 0;
        for (int val : positiveNumsSet) {
            sum += val;
        }

        return sum;
    }
}
