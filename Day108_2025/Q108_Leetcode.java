class Q108_Leetcode {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        
        String prevSay = countAndSay(n - 1);
        StringBuilder currSay = new StringBuilder();
        int count = 1;
        
        for (int i = 0; i < prevSay.length(); ++i) {
            if (i + 1 < prevSay.length() && prevSay.charAt(i) == prevSay.charAt(i + 1)) {
                count++;
            } else {
                currSay.append(count).append(prevSay.charAt(i));
                count = 1;
            }
        }
        
        return currSay.toString();
    }
}
