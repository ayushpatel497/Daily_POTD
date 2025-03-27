import java.util.*;

class Q086_Leetcode {
    public int minimumIndex(List<Integer> nums) {
        int x = nums.get(0), count = 0, xCount = 0, n = nums.size();

        // Find the dominant element
        for (int num : nums) {
            if (num == x) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                x = num;
                count = 1;
            }
        }

        // Count occurrences of dominant element
        for (int num : nums) {
            if (num == x) {
                xCount++;
            }
        }

        count = 0;
        for (int index = 0; index < n; index++) {
            if (nums.get(index) == x) {
                count++;
            }
            int remainingCount = xCount - count;
            if (count * 2 > index + 1 && remainingCount * 2 > n - index - 1) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q086_Leetcode sol = new Q086_Leetcode();
        List<Integer> nums = Arrays.asList(1, 2, 2, 2, 3, 2, 2);
        System.out.println(sol.minimumIndex(nums)); // Example Output
    }
}
