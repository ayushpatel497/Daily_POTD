import java.util.Scanner;

class Q017_Leetcode {
    public boolean doesValidArrayExist(int[] derived) {
        // Neighboring Bitwise XOR
        int xorr = 1;
        for (int num : derived) {
            xorr ^= num;
        }
        return xorr == 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input derived array
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int[] derived = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            derived[i] = sc.nextInt();
        }

        Q017_Leetcode sol = new Q017_Leetcode();
        System.out.println("Does a valid array exist? " + sol.doesValidArrayExist(derived));

        sc.close();
    }
}
