class Q134_GFG {
    private String convert(String num) {
        StringBuilder ans = new StringBuilder();
        int count = 1;
        char digit = num.charAt(0);

        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) == digit) {
                count++;
            } else {
                ans.append(count).append(digit);
                digit = num.charAt(i);
                count = 1;
            }
        }
        ans.append(count).append(digit);
        return ans.toString();
    }

    public String countAndSay(int n) {
        if (n == 1) return "1";
        String previous = countAndSay(n - 1);
        return convert(previous);
    }
}
