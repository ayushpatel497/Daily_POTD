class Q296_Leetcode {
    public boolean hasSameDigits(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 1; i <= n - 2; i++) {
            for (int j = 0; j <= n - 1 - i; j++) {
                int newDigit = ((sb.charAt(j) - '0') + (sb.charAt(j + 1) - '0')) % 10;
                sb.setCharAt(j, (char)(newDigit + '0'));
            }
        }

        return sb.charAt(0) == sb.charAt(1);
    }
}
