import java.util.*;

class Q076_Leetcode {
    public boolean divideArray(int[] nums) {
        Set<Integer> unpaired = new HashSet<>();
        
        for (int num : nums) {
            if (unpaired.contains(num)) {
                unpaired.remove(num);
            } else {
                unpaired.add(num);
            }
        }

        return unpaired.isEmpty();
    }
}
