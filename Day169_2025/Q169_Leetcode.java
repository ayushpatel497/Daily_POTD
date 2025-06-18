import java.util.*;

class Q169_Leetcode {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n % 3 != 0) return new int[0][];
        
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < n; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][];
            }
            result.add(new int[]{nums[i], nums[i + 1], nums[i + 2]});
        }

        return result.toArray(new int[0][]);
    }
}
