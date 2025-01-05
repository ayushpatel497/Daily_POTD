import java.util.*;

class Q005_Leetcode {
    public String shiftingLetters(String s, int[][] shifts) {
        // Q. Shifting Letters II
        int n = s.length();
        int[] shiftCount = new int[n + 1];

        for (int[] shift : shifts) {
            shiftCount[shift[0]] += (2 * shift[2] - 1);
            shiftCount[shift[1] + 1] -= (2 * shift[2] - 1);
        }

        StringBuilder ans = new StringBuilder();
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            preSum = (preSum + shiftCount[i]) % 26;
            char shiftedChar = (char) ('a' + (s.charAt(i) - 'a' + preSum + 26) % 26);
            ans.append(shiftedChar);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine(); // Input string
        int m = sc.nextInt();     // Number of shifts
        sc.nextLine();            // Consume newline
        int[][] shifts = new int[m][3];
        for (int i = 0; i < m; i++) {
            String[] parts = sc.nextLine().split(" ");
            shifts[i][0] = Integer.parseInt(parts[0]);
            shifts[i][1] = Integer.parseInt(parts[1]);
            shifts[i][2] = Integer.parseInt(parts[2]);
        }

        Q005_Leetcode sol = new Q005_Leetcode();
        System.out.println(sol.shiftingLetters(s, shifts));
        sc.close();
    }
}
