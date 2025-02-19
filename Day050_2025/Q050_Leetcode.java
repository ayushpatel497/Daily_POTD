import java.util.*;

class Q050_Leetcode {
    public String getHappyString(int n, int k) {
        int total = 3 * (1 << (n - 1)); // Total happy strings
        if (k > total) return "";

        StringBuilder result = new StringBuilder();
        Map<Character, Character> nextSmallest = Map.of('a', 'b', 'b', 'a', 'c', 'a');
        Map<Character, Character> nextGreatest = Map.of('a', 'c', 'b', 'c', 'c', 'b');

        int startA = 1;
        int startB = startA + (1 << (n - 1));
        int startC = startB + (1 << (n - 1));

        if (k < startB) {
            result.append('a');
            k -= startA;
        } else if (k < startC) {
            result.append('b');
            k -= startB;
        } else {
            result.append('c');
            k -= startC;
        }

        for (int charIndex = 1; charIndex < n; charIndex++) {
            int midpoint = (1 << (n - charIndex - 1));
            if (k < midpoint) {
                result.append(nextSmallest.get(result.charAt(charIndex - 1)));
            } else {
                result.append(nextGreatest.get(result.charAt(charIndex - 1)));
                k -= midpoint;
            }
        }

        return result.toString();
    }
}
