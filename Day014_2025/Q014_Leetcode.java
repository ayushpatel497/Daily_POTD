import java.util.*;

class Q014_Leetcode {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        // Q. Find the Prefix Common Array of Two Arrays
        int n = A.length;
        int[] ans = new int[n];
        int[] freq = new int[n + 1];
        int common = 0;

        for (int currInd = 0; currInd < n; ++currInd) {
            if (++freq[A[currInd]] == 2) common++;
            if (++freq[B[currInd]] == 2) common++;
            ans[currInd] = common;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] A = new int[n];
            int[] B = new int[n];

            for (int i = 0; i < n; i++) A[i] = sc.nextInt();
            for (int i = 0; i < n; i++) B[i] = sc.nextInt();

            Q014_Leetcode sol = new Q014_Leetcode();
            int[] result = sol.findThePrefixCommonArray(A, B);

            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println("\n~");
        }
        sc.close();
    }
}
