class Q175_GFG {
    public static String maxSubseq(String s, int k) {
        int n = s.length();
        int keep = n - k;
        StringBuilder ans = new StringBuilder();

        for (char ch : s.toCharArray()) {
            while (ans.length() > 0 && k > 0 && ans.charAt(ans.length() - 1) < ch) {
                ans.deleteCharAt(ans.length() - 1);
                k--;
            }
            ans.append(ch);
        }

        return ans.substring(0, keep);
    }
}
