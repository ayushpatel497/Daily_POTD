class Q056_Leetcode {
    public int numOfSubarrays(int[] arr) {
        int MOD = (int) 1e9 + 7;
        int count = 0, prefixSum = 0;
        int oddCount = 0, evenCount = 1; // evenCount is initialized to 1 to account for prefix sum = 0
        
        for (int num : arr) {
            prefixSum += num;
            if (prefixSum % 2 == 0) {
                count = (count + oddCount) % MOD;
                evenCount++;
            } else {
                count = (count + evenCount) % MOD;
                oddCount++;
            }
        }
        
        return count;
    }
}
