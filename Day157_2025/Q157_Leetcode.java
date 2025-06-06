import java.util.*;

class Q157_Leetcode {
    public String robotWithString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        char minChar = 'a';

        for (char c : s.toCharArray()) {
            stack.push(c);
            count[c - 'a']--;

            while (minChar <= 'z' && count[minChar - 'a'] == 0) {
                minChar++;
            }

            while (!stack.isEmpty() && stack.peek() <= minChar) {
                res.append(stack.pop());
            }
        }

        return res.toString();
    }
}
