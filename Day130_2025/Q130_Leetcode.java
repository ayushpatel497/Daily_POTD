class Q130_Leetcode {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        long zero1 = 0, zero2 = 0;

        for (int num : nums1) {
            sum1 += num;
            if (num == 0) {
                sum1 += 1;
                zero1++;
            }
        }

        for (int num : nums2) {
            sum2 += num;
            if (num == 0) {
                sum2 += 1;
                zero2++;
            }
        }

        if ((zero1 == 0 && sum2 > sum1) || (zero2 == 0 && sum1 > sum2)) {
            return -1;
        }

        return Math.max(sum1, sum2);
    }
}
