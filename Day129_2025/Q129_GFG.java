class Q129_GFG {
    String maxNum;

    private void helper(char[] str, int k, int idx) {
        if (k == 0) return;

        char maxDigit = str[idx];
        for (int i = idx + 1; i < str.length; i++) {
            if (str[i] > maxDigit) {
                maxDigit = str[i];
            }
        }

        if (maxDigit != str[idx]) {
            k--;
        }

        for (int i = str.length - 1; i >= idx; i--) {
            if (str[i] == maxDigit) {
                swap(str, i, idx);
                String current = new String(str);
                if (current.compareTo(maxNum) > 0) {
                    maxNum = current;
                }
                helper(str, k, idx + 1);
                swap(str, i, idx); // backtrack
            }
        }
    }

    private void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public String findMaximumNum(String s, int k) {
        maxNum = s;
        helper(s.toCharArray(), k, 0);
        return maxNum;
    }
}
