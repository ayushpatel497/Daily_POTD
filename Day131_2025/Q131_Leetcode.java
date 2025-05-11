class Q131_Leetcode {
    public boolean threeConsecutiveOdds(int[] arr) {
        int consecutiveOdds = 0;
        for (int num : arr) {
            if (num % 2 == 1) {
                consecutiveOdds++;
                if (consecutiveOdds == 3) return true;
            } else {
                consecutiveOdds = 0;
            }
        }
        return false;
    }
}
