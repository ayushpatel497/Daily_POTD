import java.util.*;

class Q269_Leetcode {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        Arrays.sort(nums);
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) continue; // skip zero side
            int k = i + 2;
            for (int j = i + 1; j < n - 1; j++) {
                while (k < n && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                count += k - j - 1;
            }
        }

        return count;
    }
}
