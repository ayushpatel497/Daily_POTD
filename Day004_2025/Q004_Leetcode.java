import java.util.*;

class Q004_Leetcode {
    public int countPalindromicSubsequence(String s) {
        // Q. Unique Length-3 Palindromic Subsequences
        int[] firstt = new int[26];
        int[] lastt = new int[26];
        Arrays.fill(firstt, Integer.MAX_VALUE);
        Arrays.fill(lastt, 0);

        for (int i = 0; i < s.length(); i++) {
            firstt[s.charAt(i) - 'a'] = Math.min(firstt[s.charAt(i) - 'a'], i);
            lastt[s.charAt(i) - 'a'] = i;
        }

        int ans = 0;

        for (int i = 0; i < 26; i++) {
            if (firstt[i] < lastt[i]) {
                HashSet<Character> uniqueChars = new HashSet<>();
                for (int j = firstt[i] + 1; j < lastt[i]; j++) {
                    uniqueChars.add(s.charAt(j));
                }
                ans += uniqueChars.size();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline after the number of test cases

        while (t-- > 0) {
            String s = sc.nextLine();
            Q004_Leetcode sol = new Q004_Leetcode();
            System.out.println(sol.countPalindromicSubsequence(s));
            System.out.println("~");
        }

        sc.close();
    }
}
