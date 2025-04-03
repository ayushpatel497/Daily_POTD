class Q093_Leetcode {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0, imax = 0, dmax = 0;
        
        for (int k = 0; k < n; k++) {
            res = Math.max(res, dmax * nums[k]);
            dmax = Math.max(dmax, imax - nums[k]);
            imax = Math.max(imax, (long) nums[k]);
        }
        
        return res;
    }

    public static void main(String[] args) {
        Q093_Leetcode sol = new Q093_Leetcode();
        int[] nums = {3, 7, 1, 5, 9}; 
        System.out.println(sol.maximumTripletValue(nums)); // Example usage
    }
}
