import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Q114_Leetcode {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int res = 0;
        
        // Find number of distinct elements in the array
        Set<Integer> distinctSet = new HashSet<>();
        for (int num : nums) distinctSet.add(num);
        int distinctCount = distinctSet.size();

        Map<Integer, Integer> countMap = new HashMap<>();
        int right = 0;

        for (int left = 0; left < n; left++) {
            if (left > 0) {
                int remove = nums[left - 1];
                countMap.put(remove, countMap.get(remove) - 1);
                if (countMap.get(remove) == 0) {
                    countMap.remove(remove);
                }
            }

            while (right < n && countMap.size() < distinctCount) {
                countMap.put(nums[right], countMap.getOrDefault(nums[right], 0) + 1);
                right++;
            }

            if (countMap.size() == distinctCount) {
                res += (n - right + 1);
            }
        }

        return res;
    }
}
