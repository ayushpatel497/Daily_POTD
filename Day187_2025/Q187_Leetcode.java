import java.util.*;

class FindSumPairs {
    private int[] nums1, nums2;
    private Map<Integer, Integer> countMap;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        countMap = new HashMap<>();
        for (int num : nums2) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        countMap.put(oldVal, countMap.get(oldVal) - 1);
        if (countMap.get(oldVal) == 0) countMap.remove(oldVal);

        nums2[index] += val;
        int newVal = nums2[index];
        countMap.put(newVal, countMap.getOrDefault(newVal, 0) + 1);
    }

    public int count(int tot) {
        int ans = 0;
        for (int num : nums1) {
            int complement = tot - num;
            ans += countMap.getOrDefault(complement, 0);
        }
        return ans;
    }
}
