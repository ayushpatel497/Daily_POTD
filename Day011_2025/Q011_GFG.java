import java.util.*;

class Q011_GFG {
    public int longestUniqueSubstr(String s) {
        // Code here
        // Q. Longest substring with distinct characters
        Map<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0;
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i), 0) + 1);
            while (charMap.get(s.charAt(i)) > 1) {
                char startChar = s.charAt(j);
                charMap.put(startChar, charMap.get(startChar) - 1);
                if (charMap.get(startChar) == 0) {
                    charMap.remove(startChar);
                }
                j++;
            }
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Q011_GFG sol = new Q011_GFG();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            System.out.println(sol.longestUniqueSubstr(s));
        }
        sc.close();
    }
}
