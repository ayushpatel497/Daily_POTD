import java.util.*;

class Q099_Leetcode {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        
        for (int x : nums) {
            if (x < k) {
                return -1;
            } else if (x > k) {
                set.add(x);
            }
        }
        
        return set.size();
    }
}
