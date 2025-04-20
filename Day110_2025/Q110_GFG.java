class Q110_GFG {
    public int findDuplicate(int[] arr) {
        int ans = 0;
        int n = arr.length; // Array size is n (elements from 1 to n-1)
        
        for (int i = 0; i < n; i++) {
            ans ^= arr[i];
        }
        
        for (int i = 1; i < n; i++) {
            ans ^= i;
        }
        
        return ans;
    }
}
