class Q110_Leetcode {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int ans : answers) {
            freqMap.put(ans, freqMap.getOrDefault(ans, 0) + 1);
        }

        int total = 0;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int x = entry.getKey();      // Rabbit says "x others like me"
            int count = entry.getValue(); // Number of such replies
            int groupSize = x + 1;
            int groups = (int) Math.ceil((double) count / groupSize);
            total += groups * groupSize;
        }
        return total;
    }
}
