import java.util.*;

class Q074_Leetcode {
    public int minCapability(int[] nums, int k) {
        int minReward = 1, maxReward = Arrays.stream(nums).max().getAsInt();
        int totalHouses = nums.length;

        while (minReward < maxReward) {
            int midReward = (minReward + maxReward) / 2;
            int possibleThefts = 0;

            for (int index = 0; index < totalHouses; index++) {
                if (nums[index] <= midReward) {
                    possibleThefts++;
                    index++; // Skip the next house
                }
            }

            if (possibleThefts >= k)
                maxReward = midReward;
            else
                minReward = midReward + 1;
        }

        return minReward;
    }
}
