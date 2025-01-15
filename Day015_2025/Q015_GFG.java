import java.util.*;

class Q015_GFG {
    public int longestSubarray(int[] arr, int k) {
        // Q. Longest Subarray with Sum K
        HashMap<Integer, Integer> um = new HashMap<>();
        um.put(0, -1); // Initializing the prefix sum 0 at index -1
        int ans = 0;
        int preSum = 0;

        for (int i = 0; i < arr.length; ++i) {
            preSum += arr[i];

            if (um.containsKey(preSum - k)) {
                ans = Math.max(ans, i - um.get(preSum - k));
            }

            if (!um.containsKey(preSum)) {
                um.put(preSum, i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline

        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

            int k = sc.nextInt();
            sc.nextLine(); // Consume newline

            Q015_GFG sol = new Q015_GFG();
            System.out.println(sol.longestSubarray(arr, k));
            System.out.println("~");
        }

        sc.close();
    }
}
