class Q053_GFG {
    static int maxLength(String s) {
        int n = s.length();
        int left = 0, right = 0, maxlength = 0;
        
        // Left-to-right scan
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;
            if (left == right)
                maxlength = Math.max(maxlength, 2 * right);
            else if (right > left)
                left = right = 0;
        }
        
        // Reset counters for right-to-left scan
        left = right = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;
            if (left == right)
                maxlength = Math.max(maxlength, 2 * left);
            else if (left > right)
                left = right = 0;
        }
        
        return maxlength;
    }
    
    public static void main(String[] args) {
        // Example usage:
        String s = "(()))(";
        System.out.println("Longest valid parentheses length: " + maxLength(s));
    }
}
