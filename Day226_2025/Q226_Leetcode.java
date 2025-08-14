class Q226_Leetcode {
    public String largestGoodInteger(String num) {
        char maxDigit = 0;
        for (int i = 0; i <= num.length() - 3; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                maxDigit = (char) Math.max(maxDigit, num.charAt(i));
            }
        }
        return maxDigit == 0 ? "" : String.valueOf(new char[]{maxDigit, maxDigit, maxDigit});
    }
}
