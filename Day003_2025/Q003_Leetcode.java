import java.util.*;

class Q003_Leetcode {
    public int waysToSplitArray(int[] nums) {
        // Q. Number of Ways to Split Array
        long preSum = 0, total = 0;
        int ans = 0;

        for (int num : nums) {
            total += num;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            preSum += nums[i];
            if (preSum >= total - preSum) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline after the number of test cases

        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int[] nums = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

            Q003_Leetcode sol = new Q003_Leetcode();
            System.out.println(sol.waysToSplitArray(nums));
            System.out.println("~");
        }

        sc.close();
    }
}
