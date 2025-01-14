import java.util.*;

class Q014_GFG {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int[] arr) {
        // Q. Equilibrium Point
        int total = Arrays.stream(arr).sum();
        int preSum = 0;

        for (int i = 0; i < arr.length; ++i) {
            preSum += arr[i];
            if (preSum - arr[i] == total - preSum) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume leftover newline

        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

            System.out.println(findEquilibrium(arr));
            System.out.println("~");
        }
        sc.close();
    }
}
