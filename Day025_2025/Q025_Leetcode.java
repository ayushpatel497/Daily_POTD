import java.util.*;

class Q025_Leetcode {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        int currGroup = 0;
        Map<Integer, Integer> numToGroup = new HashMap<>();
        Map<Integer, LinkedList<Integer>> groupToList = new HashMap<>();

        numToGroup.put(sortedNums[0], currGroup);
        groupToList.put(currGroup, new LinkedList<>(List.of(sortedNums[0])));

        for (int i = 1; i < n; i++) {
            if (Math.abs(sortedNums[i] - sortedNums[i - 1]) > limit) {
                currGroup++;
            }
            numToGroup.put(sortedNums[i], currGroup);
            groupToList.computeIfAbsent(currGroup, _ -> new LinkedList<>()).add(sortedNums[i]);
        }

        for (int i = 0; i < n; i++) {
            int group = numToGroup.get(nums[i]);
            nums[i] = groupToList.get(group).poll();
        }

        return nums;
    }
}
