class Q222_GFG {
    public int countPS(String s) {
        int n = s.length();
        int ans = 0;

        for (int mid = 0; mid < n; mid++) {
            int count = 1;
            // Odd length palindromes
            for (int i = 1; i < n - mid && mid - i >= 0; i++) {
                if (s.charAt(mid - i) == s.charAt(mid + i)) {
                    count += 1;
                } else {
                    break;
                }
            }
            ans += count;
            count = 0;

            // Even length palindromes
            for (int i = 0; i < n - mid - 1 && mid - i >= 0; i++) {
                if (s.charAt(mid - i) == s.charAt(mid + i + 1)) {
                    count += 1;
                } else {
                    break;
                }
            }
            ans += count;
        }

        return ans - n; // subtract single-character palindromes
    }
}
