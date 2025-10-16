class Q289_Leetcode {
    public int findSmallestInteger(int[] nums, int value) {
        int[] freq = new int[value];
        
        // Count frequency of each remainder
        for (int x : nums) {
            int v = ((x % value) + value) % value; // handle negatives
            freq[v]++;
        }

        int res = 0;
        while (freq[res % value] > 0) {
            freq[res % value]--;
            res++;
        }
        return res;
    }
}
