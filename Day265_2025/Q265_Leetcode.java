import java.util.*;

class Q265_Leetcode {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFrequency = 0;
        int totalFrequencies = 0;

        for (int num : nums) {
            int count = freq.getOrDefault(num, 0) + 1;
            freq.put(num, count);

            if (count > maxFrequency) {
                maxFrequency = count;
                totalFrequencies = count;
            } else if (count == maxFrequency) {
                totalFrequencies += count;
            }
        }
        return totalFrequencies;
    }
}
