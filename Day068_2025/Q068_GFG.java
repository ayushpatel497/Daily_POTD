class Q068_GFG {
    public int countPS(String s) {
        int n = s.length();
        int count = 0;

        for (int center = 0; center < n; center++) {
            // Odd length palindromes (centered at `center`)
            count += countPalindromes(s, center, center);
            // Even length palindromes (centered between `center` and `center + 1`)
            count += countPalindromes(s, center, center + 1);
        }

        return count;
    }

    private int countPalindromes(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
