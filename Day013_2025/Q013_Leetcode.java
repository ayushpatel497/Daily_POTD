import java.util.Scanner;

class Q013_Leetcode {
    public int minimumLength(String s) {
        // Q. Minimum Length of String After Operations
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int ans = 0;
        for (int f : freq) {
            if (f > 0) {
                if ((f & 1) == 1) {
                    ans += 1;
                } else {
                    ans += 2;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q013_Leetcode sol = new Q013_Leetcode();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = sc.nextLine();
        System.out.println("Minimum Length: " + sol.minimumLength(s));
        sc.close();
    }
}
