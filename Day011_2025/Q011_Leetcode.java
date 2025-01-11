import java.util.*;

class Q011_Leetcode {
    public boolean canConstruct(String s, int k) {
        // Q. Construct K Palindrome Strings
        // If the length of the string is less than k, it's not possible
        if (s.length() < k) {
            return false;
        }

        // Frequency array to count character occurrences
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Count the number of characters with odd frequency
        int odds = 0;
        for (int count : freq) {
            if (count % 2 == 1) {
                odds++;
            }
        }

        // If the number of odd frequencies is less than or equal to k, it's possible
        return odds <= k;
    }

    public static void main(String[] args) {
        Q011_Leetcode sol = new Q011_Leetcode();
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // Number of test cases
        sc.nextLine(); // Consume newline

        while (t-- > 0) {
            String s = sc.nextLine();
            int k = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.println(sol.canConstruct(s, k));
        }
        sc.close();
    }
}
