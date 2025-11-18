class Q322_Leetcode {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        int n = bits.length;
        
        while (i < n - 1) {
            i += bits[i] + 1;  // jump 1 or 2 steps
        }
        
        return i == n - 1;
    }
}
