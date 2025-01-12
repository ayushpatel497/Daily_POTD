class Q012_Leetcode {
    public boolean canBeValid(String s, String locked) {
        // Q. Check if a Parentheses String Can Be Valid
        int n = s.length();
        if (n % 2 != 0) return false;

        int minOpen = 0, maxOpen = 0;

        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                maxOpen++;
                minOpen = Math.max(minOpen - 1, 0);
            } else {
                if (s.charAt(i) == '(') {
                    minOpen++;
                    maxOpen++;
                } else {
                    maxOpen--;
                    minOpen = Math.max(minOpen - 1, 0);
                }
            }
            if (maxOpen < 0) return false;
        }

        return minOpen == 0;
    }

    public static void main(String[] args) {
        Q012_Leetcode sol = new Q012_Leetcode();
        System.out.println(sol.canBeValid("))()(", "01010")); // Example test
    }
}
