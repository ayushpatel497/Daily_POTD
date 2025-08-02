import java.util.*;

class Q214_Leetcode {
    public long minCost(int[] basket1, int[] basket2) {
        int m = Integer.MAX_VALUE;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int b1 : basket1) {
            freqMap.put(b1, freqMap.getOrDefault(b1, 0) + 1);
            m = Math.min(m, b1);
        }

        for (int b2 : basket2) {
            freqMap.put(b2, freqMap.getOrDefault(b2, 0) - 1);
            m = Math.min(m, b2);
        }

        List<Integer> merge = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int val = entry.getKey();
            int count = entry.getValue();

            if (count % 2 != 0)
                return -1;

            for (int i = 0; i < Math.abs(count) / 2; i++) {
                merge.add(val);
            }
        }

        Collections.sort(merge);
        long cost = 0;
        int half = merge.size() / 2;
        for (int i = 0; i < half; i++) {
            cost += Math.min(2L * m, merge.get(i));
        }

        return cost;
    }
}
