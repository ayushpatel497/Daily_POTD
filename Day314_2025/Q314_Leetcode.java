import java.util.*;

class Q314_Leetcode {
    public int minOperations(int[] nums) {
        List<Integer> stack = new ArrayList<>();
        int res = 0;

        for (int a : nums) {
            // Maintain a non-decreasing stack
            while (!stack.isEmpty() && stack.get(stack.size() - 1) > a) {
                stack.remove(stack.size() - 1);
            }

            if (a == 0) continue;

            // If the current number is greater than the top of stack
            if (stack.isEmpty() || stack.get(stack.size() - 1) < a) {
                res++;
                stack.add(a);
            }
        }

        return res;
    }
}
