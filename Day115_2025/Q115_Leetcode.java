import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        Map<Integer, Integer> countMap = new HashMap<>();
        long res = 0;
        int prefix = 0;
        countMap.put(0, 1); // base case

        for (int i = 0; i < n; i++) {
            if (nums.get(i) % modulo == k) {
                prefix++;
            }
            int key = (prefix - k + modulo) % modulo;
            res += countMap.getOrDefault(key, 0);
            int modVal = prefix % modulo;
            countMap.put(modVal, countMap.getOrDefault(modVal, 0) + 1);
        }

        return res;
    }
}
