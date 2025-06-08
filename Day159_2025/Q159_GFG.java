class Solution {
    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int d1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int d2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = d1 + d2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }

    private boolean checkSequence(String s, int start, int len1, int len2) {
        String part1 = s.substring(start, start + len1);
        String part2 = s.substring(start + len1, start + len1 + len2);
        String expectedSum = addStrings(part1, part2);
        int sumLen = expectedSum.length();

        if (start + len1 + len2 + sumLen > s.length()) return false;
        if (expectedSum.equals(s.substring(start + len1 + len2, start + len1 + len2 + sumLen))) {
            if (start + len1 + len2 + sumLen == s.length()) return true;
            return checkSequence(s, start + len1, len2, sumLen);
        }

        return false;
    }

    public boolean isSumString(String s) {
        int n = s.length();
        for (int len1 = 1; len1 < n; len1++) {
            for (int len2 = 1; len1 + len2 < n; len2++) {
                if (checkSequence(s, 0, len1, len2)) return true;
            }
        }
        return false;
    }
}
