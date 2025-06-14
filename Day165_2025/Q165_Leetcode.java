class Q165_Leetcode {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        String maxStr = s;
        String minStr = s;

        // For max: replace first non-9 digit with 9
        for (char c : s.toCharArray()) {
            if (c != '9') {
                maxStr = maxStr.replace(c, '9');
                break;
            }
        }

        // For min: replace first digit with 0
        char first = s.charAt(0);
        minStr = minStr.replace(first, '0');

        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }
}
