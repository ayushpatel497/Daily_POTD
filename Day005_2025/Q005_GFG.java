import java.util.*;

class Q005_GFG {
    public int countPairs(int[] arr, int target) {
        // Q. Count Pairs whose sum is less than target
        Arrays.sort(arr); // Sort the array
        int i = 0;
        int j = arr.length - 1;
        int ans = 0;

        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum < target) {
                ans += (j - i); // Count all pairs from i to j
                i++;
            } else {
                j--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine(); // Consume the newline

        while (t-- > 0) {
            String[] input = sc.nextLine().split(" "); // Read the array
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            int target = sc.nextInt(); // Read the target
            sc.nextLine(); // Consume the newline

            Q005_GFG sol = new Q005_GFG();
            System.out.println(sol.countPairs(arr, target));
            System.out.println("~");
        }

        sc.close();
    }
}