class Q075_GFG {
    static int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;  // Already at the last index
        if (arr[0] == 0) return -1;  // Can't move forward

        int maxReach = arr[0];  // Max index reachable
        int step = arr[0];  // Steps remaining in the current jump
        int jumps = 1;  // Number of jumps taken

        for (int i = 1; i < n; i++) {
            if (i == n - 1) return jumps;  // If reached the last index
            
            maxReach = Math.max(maxReach, i + arr[i]);
            step--;

            if (step == 0) {
                jumps++;  // Increase jumps
                if (i >= maxReach) return -1;  // Can't move further
                step = maxReach - i;  // Update steps for the next jump
            }
        }
        return -1;
    }
}
