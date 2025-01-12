import java.util.Scanner;

class Q012_GFG {
    public int maxWater(int[] arr) {
        // Q. Trapping Rain Water
        // Two-pointer approach
        int left = 0, right = arr.length - 1;
        int level = -1, water = 0;

        while (left < right) {
            int lower;
            if (arr[left] < arr[right]) {
                lower = arr[left++];
            } else {
                lower = arr[right--];
            }
            level = Math.max(level, lower);
            water += level - lower;
        }

        return water;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine(); // Consume newline

        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Q012_GFG sol = new Q012_GFG();
            System.out.println(sol.maxWater(arr));
        }

        sc.close();
    }
}
