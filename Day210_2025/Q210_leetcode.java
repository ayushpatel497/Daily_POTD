class Q210_Leetcode {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] pos = new int[31];
        for (int b = 0; b < 31; b++) pos[b] = -1;

        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int j = i;
            for (int b = 0; b < 31; b++) {
                if ((nums[i] & (1 << b)) != 0) {
                    pos[b] = i;                 // this bit available at i
                } else if (pos[b] != -1) {
                    j = Math.max(j, pos[b]);   // need to extend to include this bit
                }
            }
            ans[i] = j - i + 1;
        }
        return ans;
    }
}
