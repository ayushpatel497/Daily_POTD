import java.util.*;
class Q098_Leetcode {
    public int minimumOperations(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            unique.add(num);
        }
        return nums.length - unique.size();
    }
}
