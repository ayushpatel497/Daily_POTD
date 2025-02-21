class Q052_GFG {
    static boolean isBalanced(String s) {
        // Convert string to char array for in-place simulation of a stack using the string itself.
        char[] arr = s.toCharArray();
        int top = -1; // Stack pointer (top of the "stack")
        
        for (char ch : arr) {
            // If the character is an opening bracket, "push" it onto our simulated stack.
            if (ch == '(' || ch == '{' || ch == '[') {
                arr[++top] = ch;
            } else {
                // If we see a closing bracket, check if there is a matching opening bracket.
                if (top >= 0 && ((arr[top] == '(' && ch == ')') || 
                                 (arr[top] == '{' && ch == '}') || 
                                 (arr[top] == '[' && ch == ']'))) {
                    top--; // "Pop" the matching opening bracket.
                } else {
                    return false;
                }
            }
        }
        // If the simulated stack is empty, the string is balanced.
        return top == -1;
    }

    public static void main(String[] args) {
        // Sample testing
        String[] tests = {"{[()]}", "{[(])}", "((()))", "([{}])", "((({}))"};
        for (String test : tests) {
            System.out.println(test + " -> " + isBalanced(test));
        }
    }
}
