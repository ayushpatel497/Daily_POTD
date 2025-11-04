import java.util.*;

class Q308_Leetcode {
    private int getXSum(HashMap<Integer, Integer> frequency, int x) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            maxHeap.offer(new int[]{entry.getValue(), entry.getKey()});
        }

        int sum = 0;
        while (x-- > 0 && !maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            sum += top[0] * top[1];
        }

        return sum;
    }

    public int[] findXSum(int[] nums, int k, int x) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < k; i++) {
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
        }

        result.add(getXSum(frequency, x));

        for (int i = 1; i <= nums.length - k; i++) {
            frequency.put(nums[i - 1], frequency.get(nums[i - 1]) - 1);
            if (frequency.get(nums[i - 1]) == 0)
                frequency.remove(nums[i - 1]);

            frequency.put(nums[i + k - 1], frequency.getOrDefault(nums[i + k - 1], 0) + 1);
            result.add(getXSum(frequency, x));
        }

        // Convert List<Integer> to int[]
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
