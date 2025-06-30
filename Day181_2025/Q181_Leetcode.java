class Q181_Leetcode {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int res = 0;
        
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int key : freq.keySet()) {
            if (freq.containsKey(key + 1)) {
                res = Math.max(res, freq.get(key) + freq.get(key + 1));
            }
        }

        return res;
    }
}
