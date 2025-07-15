class Q196_GFG {
    public boolean divby13(String s) {
        int remainder = 0;
        for (int i = 0; i < s.length(); i++) {
            remainder = remainder * 10 + (s.charAt(i) - '0');
            remainder %= 13;
        }
        return remainder == 0;
    }
}
