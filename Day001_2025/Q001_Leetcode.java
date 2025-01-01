class Q001_Leetcode {
    public int maxScore(String s) {
        // Q. Maximum Score After Splitting a String
        int ans = 0;
        int zeros = 0;
        int ones = 0;
        
        // Count the total number of '1's in the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else if (s.charAt(i) == '1') {
                ones--;
            }
            // Calculate the max score
            ans = Math.max(ans, zeros + ones);
        }
        
        return ans;
    }

    public static void main(String[] args) {
        Q001_Leetcode sol = new Q001_Leetcode();
        
        // Example input
        String s = "011101";
        System.out.println("Max score: " + sol.maxScore(s));
        
        // Another example
        s = "00111";
        System.out.println("Max score: " + sol.maxScore(s));
    }
}
