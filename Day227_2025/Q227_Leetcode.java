class Q227_Leetcode {
    public boolean isPowerOfFour(int n) {
        if (n == 1)
            return true;
        if (n <= 0)
            return false;
        double logBase4 = Math.log(n) / Math.log(4);
        return logBase4 == (int) logBase4;
    }
}
