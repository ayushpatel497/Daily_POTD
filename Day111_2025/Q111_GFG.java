class Q111_GFG {
    int missingNum(int[] arr) {
        int n = arr.length + 1; // since one number is missing
        int xorSum = 0;
        
        for (int i = 1; i <= n; i++) {
            xorSum ^= i;
        }
        
        for (int num : arr) {
            xorSum ^= num;
        }
        
        return xorSum;
    }
}
