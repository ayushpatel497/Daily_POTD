class Q120_Leetcode {
    public int findNumbers(int[] nums) {
        int evenDigitCount = 0;

        for (int num : nums) {
            int digits = (int) Math.log10(num) + 1;
            if (digits % 2 == 0) {
                evenDigitCount++;
            }
        }

        return evenDigitCount;
    }
}
