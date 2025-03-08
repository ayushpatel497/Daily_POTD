class Q067_GFG {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";

        int start = 0, maxLen = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 1; j++) { // j=0 for odd-length, j=1 for even-length
                int low = i, high = i + j;
                while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                    int currLen = high - low + 1;
                    if (currLen > maxLen) {
                        start = low;
                        maxLen = currLen;
                    }
                    low--;
                    high++;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}
