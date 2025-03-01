class Q060_GFG {
    private int i = 0; // Pointer for tracking the current index

    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        int curr = 0;

        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                curr = curr * 10 + (s.charAt(i) - '0'); // Build the number
            } 
            else if (s.charAt(i) == '[') {
                i++; // Move past '['
                String nested = decodeString(s); // Recursively decode
                while (curr-- > 0) ans.append(nested); // Repeat the nested string
                curr = 0; // Reset the number
            } 
            else if (s.charAt(i) == ']') {
                return ans.toString(); // Return when we reach a closing bracket
            } 
            else {
                ans.append(s.charAt(i)); // Append normal characters
            }
            i++; // Move to the next character
        }

        return ans.toString();
    }
}
